import java.util.ArrayList;
import java.util.HashMap;

public class eTicket {
    private Child child;
    private CreditCard creditCard;
    private float balance;
    private float guardianLimit;
    private HashMap<Device, ArrayList<Entrance>> entranceTable;
    private String location;

    public eTicket(Child child, CreditCard creditCard, float guardianLimit) {
        this.child = child;
        this.child.setTicket(this);
        this.creditCard = creditCard;
        this.guardianLimit = guardianLimit;
        this.balance = 0;
        this.entranceTable = new HashMap<>();
        this.location = "Park Entrance";
    }

    public boolean isOutOfBalance(float devicePrice) {
        if (this.balance + devicePrice > this.guardianLimit){
            return true;
        }
        return false;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public float getBalance() {
        return balance;
    }

    public HashMap<Device, ArrayList<Entrance>> getEntranceTable() {
        return entranceTable;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addEntry(Device device, Entrance newEntry) {
        if (this.entranceTable.containsKey(device)){
            ArrayList<Entrance> currEntrance = this.entranceTable.get(device);
            currEntrance.add(newEntry);
            this.entranceTable.replace(device, currEntrance);
        }
        else{
            ArrayList<Entrance> currEntrance = new ArrayList<>();
            currEntrance.add(newEntry);
            this.entranceTable.put(device, currEntrance);
        }
        this.balance += device.getPrice();
    }

    public Entrance removeEntry(Device device) {
        ArrayList<Entrance> oldList = this.entranceTable.get(device);
        Entrance entryToRemove = oldList.remove(0);
        if (oldList.size() == 0){
            this.entranceTable.remove(device);
        }
        else{
            this.entranceTable.replace(device,oldList);
        }
        this.balance -= device.getPrice();
        return entryToRemove;
    }

    public void enterToDevice(Device device) {
        Entrance entrance_in_use = this.entranceTable.get(device).get(0);
        entrance_in_use.setInUse(true);
        device.gotEnterToByeTicket(this);
    }
        
    public Float calculateBill() {
        return this.getBalance();
    }

    public void exitFromDevice() {
        String deviceName = this.location;
        Device device = this.getDeviceByName(deviceName);
        Entrance entry = this.entranceTable.get(device).get(0);
        entry.setInUse(false);
        device.gotExitByeTicket(this,entry);
    }

    private Device getDeviceByName(String deviceName) {
        for (Device device: this.entranceTable.keySet()) {
            if(device.getName().equals(deviceName)){
                return device;
            }
        }
        return null;
    }

    public void removeUsedEntry(Entrance entry, Device device) {
        this.entranceTable.get(device).remove(entry);
    }

    @Override
    public String toString() {
        String out = this.child.getName() + "'s eTicket:\n";
        out += "\tBalance: " + this.balance;
        out += "\n\tLimit: " + this.guardianLimit;
        out += "\n\tLocation: " + this.location;
        out += "\n\tEntrance list: ";
        if (this.entranceTable.size() == 0){
            out += "empty\n";
            return out;
        }
        for (Device device: this.entranceTable.keySet()) {
            out += device.getName() + ", Number of Entrances: " + this.entranceTable.get(device).size() + ". ";
        }
        out += "\n";
        return out;
    }
}
