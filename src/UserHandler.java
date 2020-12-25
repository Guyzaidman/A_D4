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
