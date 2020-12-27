import java.util.ArrayList;
import java.util.HashMap;

public class eTicket {
    private int ID;
    private Child child;
    private CreditCard creditCard;
    private float balance;
    private float guardianLimit;
//    private Map map;
    private HashMap<Device, ArrayList<Entrance>> entranceTable;
    private String location;

    public eTicket(int ID, Child child, CreditCard creditCard, float guardianLimit) {
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getGuardianLimit() {
        return guardianLimit;
    }

    public void setGuardianLimit(float guardianLimit) {
        this.guardianLimit = guardianLimit;
    }

    public HashMap<Device, ArrayList<Entrance>> getEntranceTable() {
        return entranceTable;
    }

    public void setEntranceTable(HashMap<Device, ArrayList<Entrance>> entranceTable) {
        this.entranceTable = entranceTable;
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
        this.entranceTable.replace(device,oldList);
        this.balance -= device.getPrice();
        return entryToRemove;
    }

    public void enterToDevice(Device device) {
        device.gotEnterToByeTicket(this);
    }
        
    public Float calculateBill() {
        return this.getBalance();
    }

    public void exitFromDevice() {
        String deviceName = this.location;
        Device device = this.getDeviceByName(deviceName);
        Entrance entry = this.entranceTable.get(device).get(0);
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
            out += device.getName() + ", Entrance's Number: " + this.entranceTable.get(device).size() + ". ";
        }
        out += "\n";
        return out;
    }
}
