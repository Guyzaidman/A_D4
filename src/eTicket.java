import java.util.ArrayList;
import java.util.HashMap;

public class eTicket {
    private int ID;
    private Child child;
    private CreditCard creditCard;
    private float balance;
    private float guardianLimit;
    private Map map;
    private HashMap<Device, ArrayList<Entrance>> entranceTable;
    private String location;

    public eTicket(int ID, Child child, CreditCard creditCard, float guardianLimit, Map map) {
        this.ID = ID;
        this.child = child;
        this.creditCard = creditCard;
        this.guardianLimit = guardianLimit;
        this.map = map;
        this.balance = 0;
        this.entranceTable = new HashMap<>();
        this.location = "Park Entrance";
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
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
}
