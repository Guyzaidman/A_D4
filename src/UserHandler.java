import java.util.Date;
import java.util.HashMap;

public class UserHandler {
    private eParkSystem parkSystem;
    private HashMap<Integer, GuardianAccount> guardians;
    private HashMap<String, GuardianAccount> childNameToGuardianMap;

    public UserHandler(eParkSystem parkSystem) {
        this.parkSystem = parkSystem;
        this.guardians = new HashMap<>();
        this.childNameToGuardianMap = new HashMap<>();
    }

    public HashMap<Integer, GuardianAccount> getGuardians() {
        return guardians;
    }

    public void registerNewChild(int childId, String childName, int childAge, int creditNumber, int expirationMonth, int expirationYear, float limit, int makeAccount) {
        CreditCard creditCard = new CreditCard(creditNumber, expirationYear, expirationMonth);
        eParkSystem.systemObjects.add(creditCard);

        GuardianAccount guardianAccount;
        Map map;
        if (makeAccount == -1) {
            guardianAccount = new GuardianAccount(creditCard, this);
            this.guardians.put(guardianAccount.getID(), guardianAccount);
            eParkSystem.systemObjects.add(guardianAccount);
            map = new Map(guardianAccount);
            eParkSystem.systemObjects.add(map);
            System.out.println("Your Guardian Account ID is: " + guardianAccount.getID());
            System.out.println("If you want to add more children use it.");
        }
        else{
            guardianAccount = this.getGuardianByID(makeAccount);
            map = guardianAccount.getMap();
        }

        Child child = new Child(childId, childName, childAge, guardianAccount);
        eParkSystem.systemObjects.add(child);
        this.childNameToGuardianMap.put(child.getName(), guardianAccount);

        eTicket eTicket = new eTicket(child, creditCard, limit);
        map.addETicket(eTicket);
        eParkSystem.systemObjects.add(eTicket);
    }

    public HashMap<String, GuardianAccount> getChildNameToGuardianMap() {
        return childNameToGuardianMap;
    }

    /**
     * returns a Child object by given name.
     * @param name child's name -> String
     * @return Child.
     */
    public Child getChildById(String name) {
        GuardianAccount currentGuardian = this.childNameToGuardianMap.get(name);
        if (currentGuardian == null)
            return null;
        return currentGuardian.getChildById(name);
    }

    /**
     * Changes child's status and charge's guardian's Credit Card with given bill.
     * @param child The exiting child.
     * @return Confirmation message -> String.
     */
    public String exitChild(Child child) {
        GuardianAccount currentGuardian = this.childNameToGuardianMap.get(child.getName());
        Float billToPay = currentGuardian.calculateBill(child);
        this.unregisterChild(currentGuardian, child);
        // returns a confirmation message
        return this.chargeBill(billToPay, currentGuardian.getCreditCard());
    }

    /**
     * Unregisters child from the system (remove).
     * Disconnects the eTicket from the child.
     * @param guardianAccount the guardian account to take the child off.
     * @param child the exiting child.
     */
    public void unregisterChild(GuardianAccount guardianAccount, Child child){
        this.childNameToGuardianMap.remove(child.getName());
        guardianAccount.removeChild(child);
        child.getTicket().setChild(null);
        child.setTicket(null);
    }

    /**
     * Asks park system to charge.
     * @param billToPay bill -> Float
     * @param creditCard credit card to charge -> Credit Card.
     * @return
     */
    private String chargeBill(Float billToPay, CreditCard creditCard) {
        return this.parkSystem.chargeBill(billToPay, creditCard);
    }

    public void addMeasurement(String childName, float childHeight, float childWeight) {
        GuardianAccount guardianAccount = this.childNameToGuardianMap.get(childName);
        Child child = guardianAccount.getChildren().get(childName);
        child.setHeight(childHeight);
        child.setWeight(childWeight);
    }

    public GuardianAccount getGuardianByID(int id){
        GuardianAccount g;
        try{
            g = this.getGuardians().get(id);
        }
        catch (Exception e){
            g = null;
        }

        return g;
    }

}
