import java.util.Date;
import java.util.HashMap;

public class UserHandler {
    private eParkSystem parkSystem;
    private HashMap<Integer, GuardianAccount> guardians;
    private HashMap<String, GuardianAccount> childToGuardianMap;

    public UserHandler(eParkSystem parkSystem) {
        this.parkSystem = parkSystem;
        this.guardians = new HashMap<>();
        this.childToGuardianMap = new HashMap<>();
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

    public void registerNewChild(int childId, String childName, int childAge, int creditNumber, int expirationMonth, int expirationYear, float limit) {
        CreditCard creditCard = new CreditCard(creditNumber, expirationYear, expirationMonth);
        eParkSystem.systemObjects.add(creditCard);

        GuardianAccount guardianAccount = new GuardianAccount(0, creditCard,this);
        // check ID!!!
        this.guardians.put(guardianAccount.getID(), guardianAccount);
        eParkSystem.systemObjects.add(guardianAccount);

        Map map = new Map(guardianAccount);
        eParkSystem.systemObjects.add(map);

        Child child = new Child(childId, childName, childAge, guardianAccount);
        eParkSystem.systemObjects.add(child);
        this.childToGuardianMap.put(child.getName(), guardianAccount);

        eTicket eTicket = new eTicket(0, child, creditCard, limit);
        map.addETicket(eTicket);
        eParkSystem.systemObjects.add(eTicket);

    }

    public void addMeasurement(String childName, float childHeight, float childWeight) {
        GuardianAccount guardianAccount = this.childToGuardianMap.get(childName);
        Child child = guardianAccount.getChildren().get(childName);
        child.setHeight(childHeight);
        child.setWeight(childWeight);
    }

//    public Child getChildById(String name) {
//
//    }


}
