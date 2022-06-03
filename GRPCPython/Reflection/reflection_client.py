import grpc
import random

try:
    import house_pb2
    import house_pb2_grpc
    import_ok = True
except ImportError:
    from yagrc import importer as yagrc_importer
    import_ok = False

def import_protocols(channel):
    importer = yagrc_importer.GrpcImporter()
    importer.configure(channel)

    global house_pb2
    global house_pb2_grpc
    import house_pb2
    import house_pb2_grpc
    global import_ok
    import_ok = True

def random_time() -> dict:
    return  {
        'hour' : random.randint(0,23),
        'minutes' : random.randint(0,59)
    }


def random_temperature() -> dict:
    temperature = {}
    temperature['currentTemperature'] = random.random()*20 + 7 
    temperature['lowBound'] = random.random()*7 
    temperature['highBound'] = random.random()*10 + 30
    return temperature

def random_heater() -> dict:
    return {
        'degree' : random.randint(0,10),
        'coldEnergy' : False
    }

def random_AC() -> dict:
    return {
        'ventilatorsRunning' : random.randint(0,4),
        'flops' : random.randint(0,2),
        'displayTurned' : True
    }

def random_fridge() -> dict:
    return {
        'fridgeFilled' : random.randint(0,4),
        'timer' : random_time()
    }

def random_furnace() -> dict:
    return {
        'emittedCO' : random.random()*1000,
        'mode' : random.randint(0,2)
    }

def random_regulator() -> dict:
    res = {
        'energy' : random.randint(0,1),
    }
    if random.randint(0,1) == 0:
        res['heater'] = random_heater()
    else:
        res['airConditioner'] = random_AC()

    return res

def create_random_device(id,typ):
    device = {}
    device['ID'] = id #random.randint(1,1000)
    device['type'] = typ #random.randint(0,2)
    device['turnedOn'] = True
    device['usedEnergyOverall'] = random.randint(100,60000)
    device['temperature'] = random_temperature()
    choice = random.randint(0,2)
    if choice == 0:
        device['fridge'] = random_fridge()
    elif choice == 1:
        device['furnace'] = random_furnace()
    else:
        device['regulator'] = random_regulator()
    
    return device

def make_right_call(device : dict, method):
    if 'fridge' in device.keys():
        return method(house_pb2.Device(ID=device['ID'],type=device['type'],
        turnedOn=device['turnedOn'],usedEnergyOverall=device['usedEnergyOverall'],temperature=house_pb2.TemperatureDetails(
            currentTemperature=device['temperature']['currentTemperature'],lowBound=device['temperature']['lowBound'],
            highBound=device['temperature']['highBound']),fridge=house_pb2.FridgeDetails(fridgeFilled=device['fridge']['fridgeFilled'],
            timer=house_pb2.Time(hour=device['fridge']['timer']['hour'],minutes=device['fridge']['timer']['minutes']))))
    elif 'furnace' in device.keys():
        return method(house_pb2.Device(ID=device['ID'],type=device['type'],
        turnedOn=device['turnedOn'],usedEnergyOverall=device['usedEnergyOverall'],temperature=house_pb2.TemperatureDetails(
            currentTemperature=device['temperature']['currentTemperature'],lowBound=device['temperature']['lowBound'],
            highBound=device['temperature']['highBound']),furnace=house_pb2.FurnaceDetails(emittedCO=device['furnace']['emittedCO'],mode=device['furnace']['mode'])))
    elif 'regulator' in device.keys():
        if 'heater' in device['regulator'].keys():
            return method(house_pb2.Device(ID=device['ID'],type=device['type'],
            turnedOn=device['turnedOn'],usedEnergyOverall=device['usedEnergyOverall'],temperature=house_pb2.TemperatureDetails(
                currentTemperature=device['temperature']['currentTemperature'],lowBound=device['temperature']['lowBound'],
                highBound=device['temperature']['highBound']),regulator=house_pb2.RegulatorDetails(energy=device['regulator']['energy'],heater=house_pb2.Heater(degree=device['regulator']['heater']['degree'],
                    coldEnergy=device['regulator']['heater']['coldEnergy']))))
        else:
            return method(house_pb2.Device(ID=device['ID'],type=device['type'],
            turnedOn=device['turnedOn'],usedEnergyOverall=device['usedEnergyOverall'],temperature=house_pb2.TemperatureDetails(
                currentTemperature=device['temperature']['currentTemperature'],lowBound=device['temperature']['lowBound'],
                highBound=device['temperature']['highBound']),regulator=house_pb2.RegulatorDetails(energy=device['regulator']['energy'],
                    airConditioner=house_pb2.AC(ventilatorsRunning=device['regulator']['airConditioner']['ventilatorsRunning'],
                    flops=device['regulator']['airConditioner']['flops'],displayTurned=device['regulator']['airConditioner']['displayTurned']))))
    else:
        return None
        
def parse_input(inp : str, stub):
    parameters = {}
    dev = {}
    res = ""
    if inp == "active":
        print("Receiving all active devices in home...\n")
        res = stub.AccessibleDevices(house_pb2.Empty())
    elif inp == "getwithID":
        parameters['ID'] = int(input("ID of the device: "))
        parameters['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        print("Showing device with given ID and type...\n")
        res = stub.GetDeviceWithID(house_pb2.SearchForDevice(ID=parameters['ID'],type=parameters['type']))
    elif inp == "timer":
        parameters['ID'] = int(input("ID of the device: "))
        parameters['type'] = 0
        print("Checking timer on fridge with given ID...\n")
        res = stub.GetDeviceWithID(house_pb2.SearchForDevice(ID=parameters['ID'],type=parameters['type']))
    elif inp == "add":
        dev['ID'] = int(input("ID of the device: "))
        dev['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        dev = create_random_device(dev['ID'],dev['type'])
        print("Adding new device to manager...\n")
        res = make_right_call(dev,stub.AddDevice)
    elif inp == "remove":
        dev['ID'] = int(input("ID of the device: "))
        dev['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        dev = create_random_device(dev['ID'],dev['type'])
        print("Removing given device from manager...\n")
        res = make_right_call(dev,stub.RemoveDevice)
    elif inp == "getmp":
        dev['ID'] = int(input("ID of the device: "))
        dev['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        dev = create_random_device(dev['ID'],dev['type'])
        print("Checking temperature stats of given device...\n")
        res = make_right_call(dev,stub.GetDeviceTemperatureInfo)
    elif inp == "switch":
        dev['ID'] = int(input("ID of the device: "))
        dev['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        dev = create_random_device(dev['ID'],dev['type'])
        print("Switching power of given device...\n")
        res = make_right_call(dev,stub.SwitchTurnedOnForDevice)
    elif inp == "override":
        dev['ID'] = int(input("ID of the device: "))
        dev['type'] = int(input("Type of device (0 - Fridge, 1 - Furnace, 2 - Temperature adjuster): "))
        dev = create_random_device(dev['ID'],dev['type'])
        print("Overriding device settings...\n")
        res = make_right_call(dev,stub.OverrideDevice)
    elif inp == "furnaceMode":
        parameters['ID'] = int(input("ID of the device: "))
        parameters['type'] = 1
        print("Changing heating mode of furnace...\n")
        res = make_right_call(parameters,stub.ChangeFurnaceMode)
    elif inp == "arrangeHeater":
        parameters['ID'] = int(input("ID of the device: "))
        parameters['type'] = 2
        print("Changing settings of heater...\n")
        res = make_right_call(parameters,stub.ChangeHeaterParameters)
    elif inp == "ACdisplay":
        parameters['ID'] = int(input("ID of the device: "))
        parameters['type'] = 2
        print("Switching power of AC display...\n")
        res = make_right_call(parameters,stub.SwitchACDisplay)
    elif inp == "help":
        print("------------------------------------------------------------------------")
        print("Available commands:\n")
        print("active - Lists all devices connected to home manager as a list of IDs and types of devices")
        print("getwithID - Receive all informations about given device. You have to pass correct ID and type of device connected to manager to see details")
        print("timer - Show time present on fridge displayer. Pass ID of a fridge to get results")
        print("add - Adds given device to home manager")
        print("remove - Removes given device from home manager")
        print("getmp - Gets temperature stats of a given device")
        print("switch - Switches power of a device with given ID and type")
        print("override - Updates given device description")
        print("furnaceMode - Changes the heating mode of a given furnace")
        print("arrangeHeater - Changes setting of given heater")
        print("ACdisplay - Switches on or off display screen of given Air conditioner")
        print("help - Here you are :)")
        print("------------------------------------------------------------------------")
    else:
        print("Wrong command. Please try again typing right command")
    print(res)

if __name__ == "__main__":
    with grpc.insecure_channel('localhost:3000') as channel:
        if not import_ok:
            import_protocols(channel)
        stub = house_pb2_grpc.HouseStub(channel)
        print("Welcome to GRPC client manager!")
        while(True):
            option = ""
            option = input("Please type what would you like to do (type exit for shutdown):\n")
            if option == "exit":
                print("Ending application...")
                break
            else:
                parse_input(option.strip(),stub)
