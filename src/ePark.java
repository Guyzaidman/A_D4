import java.util.HashMap;

public class ePark {
    private int ID;
    private eParkSystem parkSystem;
    private HashMap<String,Device> devices;

    public ePark(int ID, eParkSystem parkSystem) {
        this.ID = ID;
        this.parkSystem = parkSystem;
        this.devices = new HashMap<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setDevices(HashMap<String, Device> devices) {
        this.devices = devices;
    }
}
