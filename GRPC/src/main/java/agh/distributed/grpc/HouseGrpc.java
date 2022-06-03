package agh.distributed.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: house.proto")
public final class HouseGrpc {

  private HouseGrpc() {}

  public static final String SERVICE_NAME = "House";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Empty,
      agh.distributed.grpc.HouseOuterClass.ListAllDevices> getAccessibleDevicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessibleDevices",
      requestType = agh.distributed.grpc.HouseOuterClass.Empty.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ListAllDevices.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Empty,
      agh.distributed.grpc.HouseOuterClass.ListAllDevices> getAccessibleDevicesMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Empty, agh.distributed.grpc.HouseOuterClass.ListAllDevices> getAccessibleDevicesMethod;
    if ((getAccessibleDevicesMethod = HouseGrpc.getAccessibleDevicesMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getAccessibleDevicesMethod = HouseGrpc.getAccessibleDevicesMethod) == null) {
          HouseGrpc.getAccessibleDevicesMethod = getAccessibleDevicesMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Empty, agh.distributed.grpc.HouseOuterClass.ListAllDevices>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "AccessibleDevices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ListAllDevices.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("AccessibleDevices"))
                  .build();
          }
        }
     }
     return getAccessibleDevicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.Device> getGetDeviceWithIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceWithID",
      requestType = agh.distributed.grpc.HouseOuterClass.SearchForDevice.class,
      responseType = agh.distributed.grpc.HouseOuterClass.Device.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.Device> getGetDeviceWithIDMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.Device> getGetDeviceWithIDMethod;
    if ((getGetDeviceWithIDMethod = HouseGrpc.getGetDeviceWithIDMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getGetDeviceWithIDMethod = HouseGrpc.getGetDeviceWithIDMethod) == null) {
          HouseGrpc.getGetDeviceWithIDMethod = getGetDeviceWithIDMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.Device>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "GetDeviceWithID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.SearchForDevice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("GetDeviceWithID"))
                  .build();
          }
        }
     }
     return getGetDeviceWithIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.TemperatureDetails> getGetDeviceTemperatureInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceTemperatureInfo",
      requestType = agh.distributed.grpc.HouseOuterClass.Device.class,
      responseType = agh.distributed.grpc.HouseOuterClass.TemperatureDetails.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.TemperatureDetails> getGetDeviceTemperatureInfoMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.TemperatureDetails> getGetDeviceTemperatureInfoMethod;
    if ((getGetDeviceTemperatureInfoMethod = HouseGrpc.getGetDeviceTemperatureInfoMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getGetDeviceTemperatureInfoMethod = HouseGrpc.getGetDeviceTemperatureInfoMethod) == null) {
          HouseGrpc.getGetDeviceTemperatureInfoMethod = getGetDeviceTemperatureInfoMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.TemperatureDetails>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "GetDeviceTemperatureInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.TemperatureDetails.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("GetDeviceTemperatureInfo"))
                  .build();
          }
        }
     }
     return getGetDeviceTemperatureInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.Time> getCheckFridgeTimerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckFridgeTimer",
      requestType = agh.distributed.grpc.HouseOuterClass.SearchForDevice.class,
      responseType = agh.distributed.grpc.HouseOuterClass.Time.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.Time> getCheckFridgeTimerMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.Time> getCheckFridgeTimerMethod;
    if ((getCheckFridgeTimerMethod = HouseGrpc.getCheckFridgeTimerMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getCheckFridgeTimerMethod = HouseGrpc.getCheckFridgeTimerMethod) == null) {
          HouseGrpc.getCheckFridgeTimerMethod = getCheckFridgeTimerMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.Time>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "CheckFridgeTimer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.SearchForDevice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Time.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("CheckFridgeTimer"))
                  .build();
          }
        }
     }
     return getCheckFridgeTimerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getAddDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDevice",
      requestType = agh.distributed.grpc.HouseOuterClass.Device.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getAddDeviceMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall> getAddDeviceMethod;
    if ((getAddDeviceMethod = HouseGrpc.getAddDeviceMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getAddDeviceMethod = HouseGrpc.getAddDeviceMethod) == null) {
          HouseGrpc.getAddDeviceMethod = getAddDeviceMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "AddDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("AddDevice"))
                  .build();
          }
        }
     }
     return getAddDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getOverrideDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OverrideDevice",
      requestType = agh.distributed.grpc.HouseOuterClass.Device.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getOverrideDeviceMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall> getOverrideDeviceMethod;
    if ((getOverrideDeviceMethod = HouseGrpc.getOverrideDeviceMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getOverrideDeviceMethod = HouseGrpc.getOverrideDeviceMethod) == null) {
          HouseGrpc.getOverrideDeviceMethod = getOverrideDeviceMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "OverrideDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("OverrideDevice"))
                  .build();
          }
        }
     }
     return getOverrideDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getRemoveDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveDevice",
      requestType = agh.distributed.grpc.HouseOuterClass.Device.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getRemoveDeviceMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall> getRemoveDeviceMethod;
    if ((getRemoveDeviceMethod = HouseGrpc.getRemoveDeviceMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getRemoveDeviceMethod = HouseGrpc.getRemoveDeviceMethod) == null) {
          HouseGrpc.getRemoveDeviceMethod = getRemoveDeviceMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "RemoveDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("RemoveDevice"))
                  .build();
          }
        }
     }
     return getRemoveDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchTurnedOnForDeviceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchTurnedOnForDevice",
      requestType = agh.distributed.grpc.HouseOuterClass.Device.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchTurnedOnForDeviceMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchTurnedOnForDeviceMethod;
    if ((getSwitchTurnedOnForDeviceMethod = HouseGrpc.getSwitchTurnedOnForDeviceMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getSwitchTurnedOnForDeviceMethod = HouseGrpc.getSwitchTurnedOnForDeviceMethod) == null) {
          HouseGrpc.getSwitchTurnedOnForDeviceMethod = getSwitchTurnedOnForDeviceMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.Device, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "SwitchTurnedOnForDevice"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.Device.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("SwitchTurnedOnForDevice"))
                  .build();
          }
        }
     }
     return getSwitchTurnedOnForDeviceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeFurnaceModeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeFurnaceMode",
      requestType = agh.distributed.grpc.HouseOuterClass.SearchForDevice.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeFurnaceModeMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeFurnaceModeMethod;
    if ((getChangeFurnaceModeMethod = HouseGrpc.getChangeFurnaceModeMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getChangeFurnaceModeMethod = HouseGrpc.getChangeFurnaceModeMethod) == null) {
          HouseGrpc.getChangeFurnaceModeMethod = getChangeFurnaceModeMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "ChangeFurnaceMode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.SearchForDevice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("ChangeFurnaceMode"))
                  .build();
          }
        }
     }
     return getChangeFurnaceModeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeHeaterParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangeHeaterParameters",
      requestType = agh.distributed.grpc.HouseOuterClass.SearchForDevice.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeHeaterParametersMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall> getChangeHeaterParametersMethod;
    if ((getChangeHeaterParametersMethod = HouseGrpc.getChangeHeaterParametersMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getChangeHeaterParametersMethod = HouseGrpc.getChangeHeaterParametersMethod) == null) {
          HouseGrpc.getChangeHeaterParametersMethod = getChangeHeaterParametersMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "ChangeHeaterParameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.SearchForDevice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("ChangeHeaterParameters"))
                  .build();
          }
        }
     }
     return getChangeHeaterParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchACDisplayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SwitchACDisplay",
      requestType = agh.distributed.grpc.HouseOuterClass.SearchForDevice.class,
      responseType = agh.distributed.grpc.HouseOuterClass.ResponseCall.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice,
      agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchACDisplayMethod() {
    io.grpc.MethodDescriptor<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall> getSwitchACDisplayMethod;
    if ((getSwitchACDisplayMethod = HouseGrpc.getSwitchACDisplayMethod) == null) {
      synchronized (HouseGrpc.class) {
        if ((getSwitchACDisplayMethod = HouseGrpc.getSwitchACDisplayMethod) == null) {
          HouseGrpc.getSwitchACDisplayMethod = getSwitchACDisplayMethod = 
              io.grpc.MethodDescriptor.<agh.distributed.grpc.HouseOuterClass.SearchForDevice, agh.distributed.grpc.HouseOuterClass.ResponseCall>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "House", "SwitchACDisplay"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.SearchForDevice.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  agh.distributed.grpc.HouseOuterClass.ResponseCall.getDefaultInstance()))
                  .setSchemaDescriptor(new HouseMethodDescriptorSupplier("SwitchACDisplay"))
                  .build();
          }
        }
     }
     return getSwitchACDisplayMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HouseStub newStub(io.grpc.Channel channel) {
    return new HouseStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HouseBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HouseBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HouseFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HouseFutureStub(channel);
  }

  /**
   */
  public static abstract class HouseImplBase implements io.grpc.BindableService {

    /**
     */
    public void accessibleDevices(agh.distributed.grpc.HouseOuterClass.Empty request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ListAllDevices> responseObserver) {
      asyncUnimplementedUnaryCall(getAccessibleDevicesMethod(), responseObserver);
    }

    /**
     */
    public void getDeviceWithID(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Device> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceWithIDMethod(), responseObserver);
    }

    /**
     */
    public void getDeviceTemperatureInfo(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.TemperatureDetails> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceTemperatureInfoMethod(), responseObserver);
    }

    /**
     */
    public void checkFridgeTimer(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Time> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckFridgeTimerMethod(), responseObserver);
    }

    /**
     */
    public void addDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getAddDeviceMethod(), responseObserver);
    }

    /**
     * <pre>
     * new
     * </pre>
     */
    public void overrideDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getOverrideDeviceMethod(), responseObserver);
    }

    /**
     */
    public void removeDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveDeviceMethod(), responseObserver);
    }

    /**
     */
    public void switchTurnedOnForDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchTurnedOnForDeviceMethod(), responseObserver);
    }

    /**
     * <pre>
     *new from here
     * </pre>
     */
    public void changeFurnaceMode(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeFurnaceModeMethod(), responseObserver);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public void changeHeaterParameters(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getChangeHeaterParametersMethod(), responseObserver);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public void switchACDisplay(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchACDisplayMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAccessibleDevicesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Empty,
                agh.distributed.grpc.HouseOuterClass.ListAllDevices>(
                  this, METHODID_ACCESSIBLE_DEVICES)))
          .addMethod(
            getGetDeviceWithIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.SearchForDevice,
                agh.distributed.grpc.HouseOuterClass.Device>(
                  this, METHODID_GET_DEVICE_WITH_ID)))
          .addMethod(
            getGetDeviceTemperatureInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Device,
                agh.distributed.grpc.HouseOuterClass.TemperatureDetails>(
                  this, METHODID_GET_DEVICE_TEMPERATURE_INFO)))
          .addMethod(
            getCheckFridgeTimerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.SearchForDevice,
                agh.distributed.grpc.HouseOuterClass.Time>(
                  this, METHODID_CHECK_FRIDGE_TIMER)))
          .addMethod(
            getAddDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Device,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_ADD_DEVICE)))
          .addMethod(
            getOverrideDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Device,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_OVERRIDE_DEVICE)))
          .addMethod(
            getRemoveDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Device,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_REMOVE_DEVICE)))
          .addMethod(
            getSwitchTurnedOnForDeviceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.Device,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_SWITCH_TURNED_ON_FOR_DEVICE)))
          .addMethod(
            getChangeFurnaceModeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.SearchForDevice,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_CHANGE_FURNACE_MODE)))
          .addMethod(
            getChangeHeaterParametersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.SearchForDevice,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_CHANGE_HEATER_PARAMETERS)))
          .addMethod(
            getSwitchACDisplayMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                agh.distributed.grpc.HouseOuterClass.SearchForDevice,
                agh.distributed.grpc.HouseOuterClass.ResponseCall>(
                  this, METHODID_SWITCH_ACDISPLAY)))
          .build();
    }
  }

  /**
   */
  public static final class HouseStub extends io.grpc.stub.AbstractStub<HouseStub> {
    private HouseStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HouseStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HouseStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HouseStub(channel, callOptions);
    }

    /**
     */
    public void accessibleDevices(agh.distributed.grpc.HouseOuterClass.Empty request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ListAllDevices> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAccessibleDevicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDeviceWithID(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Device> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceWithIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDeviceTemperatureInfo(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.TemperatureDetails> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceTemperatureInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkFridgeTimer(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Time> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckFridgeTimerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddDeviceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * new
     * </pre>
     */
    public void overrideDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOverrideDeviceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveDeviceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchTurnedOnForDevice(agh.distributed.grpc.HouseOuterClass.Device request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchTurnedOnForDeviceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *new from here
     * </pre>
     */
    public void changeFurnaceMode(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeFurnaceModeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public void changeHeaterParameters(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getChangeHeaterParametersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public void switchACDisplay(agh.distributed.grpc.HouseOuterClass.SearchForDevice request,
        io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchACDisplayMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HouseBlockingStub extends io.grpc.stub.AbstractStub<HouseBlockingStub> {
    private HouseBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HouseBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HouseBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HouseBlockingStub(channel, callOptions);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.ListAllDevices accessibleDevices(agh.distributed.grpc.HouseOuterClass.Empty request) {
      return blockingUnaryCall(
          getChannel(), getAccessibleDevicesMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.Device getDeviceWithID(agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceWithIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.TemperatureDetails getDeviceTemperatureInfo(agh.distributed.grpc.HouseOuterClass.Device request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceTemperatureInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.Time checkFridgeTimer(agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return blockingUnaryCall(
          getChannel(), getCheckFridgeTimerMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall addDevice(agh.distributed.grpc.HouseOuterClass.Device request) {
      return blockingUnaryCall(
          getChannel(), getAddDeviceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * new
     * </pre>
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall overrideDevice(agh.distributed.grpc.HouseOuterClass.Device request) {
      return blockingUnaryCall(
          getChannel(), getOverrideDeviceMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall removeDevice(agh.distributed.grpc.HouseOuterClass.Device request) {
      return blockingUnaryCall(
          getChannel(), getRemoveDeviceMethod(), getCallOptions(), request);
    }

    /**
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall switchTurnedOnForDevice(agh.distributed.grpc.HouseOuterClass.Device request) {
      return blockingUnaryCall(
          getChannel(), getSwitchTurnedOnForDeviceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *new from here
     * </pre>
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall changeFurnaceMode(agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return blockingUnaryCall(
          getChannel(), getChangeFurnaceModeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall changeHeaterParameters(agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return blockingUnaryCall(
          getChannel(), getChangeHeaterParametersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public agh.distributed.grpc.HouseOuterClass.ResponseCall switchACDisplay(agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return blockingUnaryCall(
          getChannel(), getSwitchACDisplayMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HouseFutureStub extends io.grpc.stub.AbstractStub<HouseFutureStub> {
    private HouseFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HouseFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HouseFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HouseFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ListAllDevices> accessibleDevices(
        agh.distributed.grpc.HouseOuterClass.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getAccessibleDevicesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.Device> getDeviceWithID(
        agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceWithIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.TemperatureDetails> getDeviceTemperatureInfo(
        agh.distributed.grpc.HouseOuterClass.Device request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceTemperatureInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.Time> checkFridgeTimer(
        agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckFridgeTimerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> addDevice(
        agh.distributed.grpc.HouseOuterClass.Device request) {
      return futureUnaryCall(
          getChannel().newCall(getAddDeviceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * new
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> overrideDevice(
        agh.distributed.grpc.HouseOuterClass.Device request) {
      return futureUnaryCall(
          getChannel().newCall(getOverrideDeviceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> removeDevice(
        agh.distributed.grpc.HouseOuterClass.Device request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveDeviceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> switchTurnedOnForDevice(
        agh.distributed.grpc.HouseOuterClass.Device request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchTurnedOnForDeviceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *new from here
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> changeFurnaceMode(
        agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeFurnaceModeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> changeHeaterParameters(
        agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return futureUnaryCall(
          getChannel().newCall(getChangeHeaterParametersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *new
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<agh.distributed.grpc.HouseOuterClass.ResponseCall> switchACDisplay(
        agh.distributed.grpc.HouseOuterClass.SearchForDevice request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchACDisplayMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACCESSIBLE_DEVICES = 0;
  private static final int METHODID_GET_DEVICE_WITH_ID = 1;
  private static final int METHODID_GET_DEVICE_TEMPERATURE_INFO = 2;
  private static final int METHODID_CHECK_FRIDGE_TIMER = 3;
  private static final int METHODID_ADD_DEVICE = 4;
  private static final int METHODID_OVERRIDE_DEVICE = 5;
  private static final int METHODID_REMOVE_DEVICE = 6;
  private static final int METHODID_SWITCH_TURNED_ON_FOR_DEVICE = 7;
  private static final int METHODID_CHANGE_FURNACE_MODE = 8;
  private static final int METHODID_CHANGE_HEATER_PARAMETERS = 9;
  private static final int METHODID_SWITCH_ACDISPLAY = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HouseImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HouseImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACCESSIBLE_DEVICES:
          serviceImpl.accessibleDevices((agh.distributed.grpc.HouseOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ListAllDevices>) responseObserver);
          break;
        case METHODID_GET_DEVICE_WITH_ID:
          serviceImpl.getDeviceWithID((agh.distributed.grpc.HouseOuterClass.SearchForDevice) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Device>) responseObserver);
          break;
        case METHODID_GET_DEVICE_TEMPERATURE_INFO:
          serviceImpl.getDeviceTemperatureInfo((agh.distributed.grpc.HouseOuterClass.Device) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.TemperatureDetails>) responseObserver);
          break;
        case METHODID_CHECK_FRIDGE_TIMER:
          serviceImpl.checkFridgeTimer((agh.distributed.grpc.HouseOuterClass.SearchForDevice) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.Time>) responseObserver);
          break;
        case METHODID_ADD_DEVICE:
          serviceImpl.addDevice((agh.distributed.grpc.HouseOuterClass.Device) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_OVERRIDE_DEVICE:
          serviceImpl.overrideDevice((agh.distributed.grpc.HouseOuterClass.Device) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_REMOVE_DEVICE:
          serviceImpl.removeDevice((agh.distributed.grpc.HouseOuterClass.Device) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_SWITCH_TURNED_ON_FOR_DEVICE:
          serviceImpl.switchTurnedOnForDevice((agh.distributed.grpc.HouseOuterClass.Device) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_CHANGE_FURNACE_MODE:
          serviceImpl.changeFurnaceMode((agh.distributed.grpc.HouseOuterClass.SearchForDevice) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_CHANGE_HEATER_PARAMETERS:
          serviceImpl.changeHeaterParameters((agh.distributed.grpc.HouseOuterClass.SearchForDevice) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        case METHODID_SWITCH_ACDISPLAY:
          serviceImpl.switchACDisplay((agh.distributed.grpc.HouseOuterClass.SearchForDevice) request,
              (io.grpc.stub.StreamObserver<agh.distributed.grpc.HouseOuterClass.ResponseCall>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HouseBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return agh.distributed.grpc.HouseOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("House");
    }
  }

  private static final class HouseFileDescriptorSupplier
      extends HouseBaseDescriptorSupplier {
    HouseFileDescriptorSupplier() {}
  }

  private static final class HouseMethodDescriptorSupplier
      extends HouseBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HouseMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HouseGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HouseFileDescriptorSupplier())
              .addMethod(getAccessibleDevicesMethod())
              .addMethod(getGetDeviceWithIDMethod())
              .addMethod(getGetDeviceTemperatureInfoMethod())
              .addMethod(getCheckFridgeTimerMethod())
              .addMethod(getAddDeviceMethod())
              .addMethod(getOverrideDeviceMethod())
              .addMethod(getRemoveDeviceMethod())
              .addMethod(getSwitchTurnedOnForDeviceMethod())
              .addMethod(getChangeFurnaceModeMethod())
              .addMethod(getChangeHeaterParametersMethod())
              .addMethod(getSwitchACDisplayMethod())
              .build();
        }
      }
    }
    return result;
  }
}
