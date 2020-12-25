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
    
    }
        
    public Float calculateBill() {
        return this.getBalance();
    }
}
