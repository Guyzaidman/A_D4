import java.util.Date;
import java.util.HashMap;

public class UserHandler {
    private int ID;
    private eParkSystem parkSystem;
    private HashMap<Integer, GuardianAccount> guardians;

    public UserHandler(int ID, eParkSystem parkSystem) {
        this.ID = ID;
        this.parkSystem = parkSystem;
        this.guardians = new HashMap<>();
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

    public HashMap<Integer, GuardianAccount> getGuardians() {
        return guardians;
    }

    public void setGuardians(HashMap<Integer, GuardianAccount> guardians) {
        this.guardians = guardians;
    }

    public boolean isValid(int creditNumber, Date expirationDate, float maxAmount) {
        return true;
    }

//    public GuardianAccount createGuardianAccount(CreditCard creditCard) {
//
//    }
//
//    public Child createChild(int id, String name, int age, GuardianAccount guardianAccount) {
//    }
//
//    public eTicket createETicket(CreditCard creditCard, Child child, float maxAmount) {
//    }
}
