package House;
import agh.distributed.grpc.HouseGrpc;
import agh.distributed.grpc.HouseOuterClass;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class HouseService extends HouseGrpc.HouseImplBase {
    private final ArrayList<HouseOuterClass.Device> activeDevices = new ArrayList<>();
    @Override
    public void accessibleDevices(HouseOuterClass.Empty request, StreamObserver<HouseOuterClass.ListAllDevices> responseObserver) {
        HouseOuterClass.ListAllDevices.Builder response = HouseOuterClass.ListAllDevices.newBuilder();
        ArrayList<String> IDs = new ArrayList<>();
        ArrayList<HouseOuterClass.deviceType> types = new ArrayList<>();
        for(HouseOuterClass.Device dev : activeDevices){
            IDs.add(Integer.toString(dev.getID()));
            types.add(dev.getType());
        }
        response.addAllDeviceID(IDs);
        response.addAllDeviceType(types);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getDeviceWithID(HouseOuterClass.SearchForDevice request, StreamObserver<HouseOuterClass.Device> responseObserver) {
        HouseOuterClass.Device.Builder response = HouseOuterClass.Device.newBuilder();
        boolean found = false;
        for(HouseOuterClass.Device dev : activeDevices){
            if(dev.getID() == request.getID() && dev.getType() == request.getType()){
                response.setID(dev.getID());
                response.setType(dev.getType());
                response.setTurnedOn(dev.getTurnedOn());
                response.setTemperature(dev.getTemperature());
                response.setUsedEnergyOverall(dev.getUsedEnergyOverall());
                if(dev.hasFridge())
                    response.setFridge(dev.getFridge());
                else if(dev.hasFurnace()){
                    response.setFurnace(dev.getFurnace());
                }
                else
                    response.setRegulator(dev.getRegulator());
                found = true;
                break;
            }
        }
        if (!found){
            Status status = Status.NOT_FOUND.withDescription("Could not found device with given ID and type!");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getDeviceTemperatureInfo(HouseOuterClass.Device request, StreamObserver<HouseOuterClass.TemperatureDetails> responseObserver) {
        HouseOuterClass.TemperatureDetails.Builder response = HouseOuterClass.TemperatureDetails.newBuilder();
        response.setCurrentTemperature(request.getTemperature().getCurrentTemperature());
        response.setLowBound(request.getTemperature().getLowBound());
        response.setHighBound(request.getTemperature().getHighBound());
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void checkFridgeTimer(HouseOuterClass.SearchForDevice request, StreamObserver<HouseOuterClass.Time> responseObserver) {
        HouseOuterClass.Time.Builder response = HouseOuterClass.Time.newBuilder();
        if (request.getType() != HouseOuterClass.deviceType.FRIDGE){
            Status status = Status.INVALID_ARGUMENT.withDescription("Devices that are not fridge do not have a timer!");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        boolean found = false;
        for(HouseOuterClass.Device dev : activeDevices){
            if(dev.getID() == request.getID() && dev.getType() == request.getType()){
                response.setHour(dev.getFridge().getTimer().getHour());
                response.setMinutes(dev.getFridge().getTimer().getMinutes());
                found = true;
                break;
            }
        }
        if (!found){
            Status status = Status.NOT_FOUND.withDescription("Could not found device with given ID and type!");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void addDevice(HouseOuterClass.Device request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.Device.Builder response = getCopy(request);
        HouseOuterClass.ResponseCall.Builder notification = HouseOuterClass.ResponseCall.newBuilder();
        HouseOuterClass.Device dev = response.build();
        activeDevices.add(dev);
        if(activeDevices.contains(dev)){
            notification.setNotification("Success! New device has been added to house manager.");
            notification.setCode(200);
        }
        else{
            notification.setNotification("Failed! New device could not be added to the manager.");
            notification.setCode(417);
        }
        responseObserver.onNext(notification.build());
        responseObserver.onCompleted();
    }

    @Override
    public void removeDevice(HouseOuterClass.Device request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.Device.Builder response = getCopy(request);
        HouseOuterClass.ResponseCall.Builder notification = HouseOuterClass.ResponseCall.newBuilder();
        HouseOuterClass.Device dev = response.build();
        boolean removedSuccess = false;
        for(HouseOuterClass.Device activeDevice : activeDevices){
            if(compareDevices(activeDevice,dev)){
                activeDevices.remove(activeDevice);
                notification.setNotification("Success! Given device has been removed from the manager.");
                notification.setCode(200);
                removedSuccess = true;
                break;
            }
        }

        if (!removedSuccess){
            notification.setNotification("Failed! Device has not been removed from the manager.");
            notification.setCode(417);
        }
        responseObserver.onNext(notification.build());
        responseObserver.onCompleted();
    }

    @Override
    public void switchTurnedOnForDevice(HouseOuterClass.Device request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.Device found = null;
        HouseOuterClass.ResponseCall.Builder notification = HouseOuterClass.ResponseCall.newBuilder();
        for(HouseOuterClass.Device dev : activeDevices){
            if(compareDevices(request,dev)){
                found = dev;
                break;
            }
        }
        if (found == null){
            Status status = Status.NOT_FOUND.withDescription("Could not found device with given ID and type!");
            responseObserver.onError(status.asRuntimeException());
        }else{
            HouseOuterClass.Device.Builder response = getCopy(found);
            String before = response.getTurnedOn() ? "Working" : "Stopped";
            response.setTurnedOn(!response.getTurnedOn());
            String after = !response.getTurnedOn() ? "Stopped" : "Working";
            notification.setNotification("Device with ID : " + found.getID() +
                    " has been switched from " + before + " to "+ after);
            notification.setCode(200);
            activeDevices.set(activeDevices.indexOf(found),response.build());
            responseObserver.onNext(notification.build());
            responseObserver.onCompleted();
        }
    }

    public HouseOuterClass.Device.Builder getCopy(HouseOuterClass.Device request) {
        HouseOuterClass.Device.Builder response = HouseOuterClass.Device.newBuilder();
        response.setID(request.getID());
        response.setType(request.getType());
        response.setTurnedOn(request.getTurnedOn());
        response.setUsedEnergyOverall(request.getUsedEnergyOverall());
        response.setTemperature(request.getTemperature());
        if (request.hasFridge())
            response.setFridge(request.getFridge());
        else if (request.hasFurnace()) {
            response.setFurnace(request.getFurnace());
        } else
            response.setRegulator(request.getRegulator());

        return response;}

    public boolean compareDevices(HouseOuterClass.Device first, HouseOuterClass.Device second){
        return (first.getID() == second.getID()) && (first.getType() == second.getType());
    }

    public boolean compareDevices(HouseOuterClass.SearchForDevice first, HouseOuterClass.Device second){
        return (first.getID() == second.getID()) && (first.getType() == second.getType());
    }

    @Override
    public void overrideDevice(HouseOuterClass.Device request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.ResponseCall.Builder response = HouseOuterClass.ResponseCall.newBuilder();
        response.setCode(417);
        response.setNotification("Could not find given device in home manager");
        for(HouseOuterClass.Device dev : activeDevices){
            if(compareDevices(request,dev)){
                activeDevices.set(activeDevices.indexOf(dev),request);
                response.setCode(200);
                response.setNotification("Device description has been updated!");
                break;
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void changeFurnaceMode(HouseOuterClass.SearchForDevice request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.ResponseCall.Builder response = HouseOuterClass.ResponseCall.newBuilder();
        response.setNotification("Could not find given furnace at home manager!");
        response.setCode(417);
        if(request.getType() != HouseOuterClass.deviceType.FURNACE){
            Status status = Status.INVALID_ARGUMENT.withDescription("Cannot perform a given operation on device that is not furnace");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        for(HouseOuterClass.Device dev : activeDevices){
            if(compareDevices(request,dev)){
                HouseOuterClass.Device.Builder updated = getCopy(dev);
                HouseOuterClass.FurnaceDetails.Builder furnace = HouseOuterClass.FurnaceDetails.newBuilder();
                furnace.setModeValue((updated.getFurnace().getMode().getNumber() + 1) % 3);
                furnace.setEmittedCO(updated.getFurnace().getEmittedCO());
                updated.setFurnace(furnace.build());
                activeDevices.set(activeDevices.indexOf(dev),updated.build());
                response.setNotification("Changed heating mode of furnace!");
                response.setCode(200);
                break;
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void changeHeaterParameters(HouseOuterClass.SearchForDevice request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.ResponseCall.Builder response = HouseOuterClass.ResponseCall.newBuilder();
        response.setNotification("Could not find given heater at home manager!");
        response.setCode(417);
        if(request.getType() != HouseOuterClass.deviceType.TMPREGULATOR){
            Status status = Status.INVALID_ARGUMENT.withDescription("Cannot perform a given operation on device that is not a regulator");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        for(HouseOuterClass.Device dev : activeDevices){
            if(compareDevices(request,dev)){
                if(!dev.getRegulator().hasHeater()){
                    continue;
                }
                HouseOuterClass.Device.Builder updated = getCopy(dev);

                HouseOuterClass.Heater.Builder heater = HouseOuterClass.Heater.newBuilder();
                heater.setDegree((dev.getRegulator().getHeater().getDegree() + 1) % 11);
                heater.setColdEnergy(heater.getDegree() < 5);

                HouseOuterClass.RegulatorDetails.Builder regulator = HouseOuterClass.RegulatorDetails.newBuilder();
                regulator.setEnergyValue(dev.getRegulator().getEnergyValue());
                regulator.setHeater(heater.build());

                updated.setRegulator(regulator.build());
                activeDevices.set(activeDevices.indexOf(dev),updated.build());

                response.setNotification("Changed setting of heater for that regulator!");
                response.setCode(200);
                break;
            }
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void switchACDisplay(HouseOuterClass.SearchForDevice request, StreamObserver<HouseOuterClass.ResponseCall> responseObserver) {
        HouseOuterClass.ResponseCall.Builder response = HouseOuterClass.ResponseCall.newBuilder();
        response.setNotification("Could not find given air conditioner at home manager!");
        response.setCode(417);
        if(request.getType() != HouseOuterClass.deviceType.TMPREGULATOR){
            Status status = Status.INVALID_ARGUMENT.withDescription("Cannot perform a given operation on device that is not a regulator");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        for(HouseOuterClass.Device dev : activeDevices){
            if(compareDevices(request,dev)){
                if(dev.getRegulator().hasHeater()){
                    continue;
                }
                String state = dev.getRegulator().getAirConditioner().getDisplayTurned() ? "On" : "Off";
                String after = !dev.getRegulator().getAirConditioner().getDisplayTurned() ? "On" : "Off";

                HouseOuterClass.Device.Builder updated = getCopy(dev);
                HouseOuterClass.AC.Builder AC = HouseOuterClass.AC.newBuilder();
                AC.setDisplayTurned(!dev.getRegulator().getAirConditioner().getDisplayTurned());
                AC.setFlopsValue(dev.getRegulator().getAirConditioner().getFlopsValue());
                AC.setVentilatorsRunning(dev.getRegulator().getAirConditioner().getVentilatorsRunning());

                HouseOuterClass.RegulatorDetails.Builder regulator = HouseOuterClass.RegulatorDetails.newBuilder();
                regulator.setEnergyValue(dev.getRegulator().getEnergyValue());
                regulator.setAirConditioner(AC.build());

                updated.setRegulator(regulator.build());
                activeDevices.set(activeDevices.indexOf(dev),updated.build());

                response.setNotification("Changed display of air conditioner from " + state + " to " + after);
                response.setCode(200);
                break;
            }

        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}

