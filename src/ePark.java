import java.util.ArrayList;
import java.util.HashMap;

public class ePark {
    private eParkSystem parkSystem;
    private HashMap<String,Device> devices;

    public ePark(eParkSystem parkSystem) {
        this.parkSystem = parkSystem;
        this.devices = new HashMap<>();
    }

    public eParkSystem getParkSystem() {
        return parkSystem;
    }

    public void setParkSystem(eParkSystem parkSystem) {
        this.parkSystem = parkSystem;
    }

    public HashMap<String, Device> getDevices() {
        return devices;
    }

    public void setDevices(String name, Device device) {
        this.devices.put(name,device);
    }

    public ArrayList<Device> getSuitableDevices(Child child) {
        ArrayList<Device> devices = new ArrayList<>();
        int childAge = child.getAge();
        float childWeight = child.getWeight();
        float childHeight  = child.getHeight();
        for (Device device: this.devices.values()) {
            if (device.isSuitable(childAge, childWeight, childHeight)){
                devices.add(device);
            }
        }
        return devices;
    }

    public void DeviceGotEnter(Device device, eTicket ticket) {
        this.parkSystem.EnterToDeviceHandler(device,ticket);
    }

    public void gotExitFromDevice(Device device, eTicket ticket, Entrance entry) {
        this.parkSystem.ExitFromDeviceHandler(device,ticket,entry);
    }
}
