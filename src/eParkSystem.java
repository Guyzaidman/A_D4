import java.util.ArrayList;
import java.util.Date;

public class eParkSystem {

    private UserHandler userHandler;
    private PaymentHandler paymentHandler;
    private ePark park;
    private DeviceFactory deviceFactory;
    public static ArrayList<Object> systemObjects = new ArrayList<>();

    public eParkSystem() {
        this.userHandler = new UserHandler(this);
        this.paymentHandler = new PaymentHandler(this);
        this.park = new ePark(this);
        this.deviceFactory = new DeviceFactory();

    }

    public ePark getPark() {
        return park;
    }

    public DeviceFactory getDeviceFactory() {
        return deviceFactory;
    }

    public static ArrayList<Object> getSystemObjects(){
        return eParkSystem.systemObjects;
    }

    public void enterDetails(String childId, String childAge, String hasAccount) throws Exception
    {
        int IDInt;
        try {
            IDInt = Integer.parseInt(childId);
        } catch(Exception e){
            throw new Exception("Not a valid ID.");
        }
        if(IDInt < 0){
            throw new Exception("Not a valid ID.");
        }

        int ageInt;
        try {
            ageInt = Integer.parseInt(childAge);
        } catch(Exception e){
            throw new Exception("Not a valid age.");
        }
        if(ageInt < 0){
            throw new Exception("Not a valid ageInt.");
        }

        int hasAccountInt;
        try {
            hasAccountInt = Integer.parseInt(hasAccount);
        } catch(Exception e){
            throw new Exception("Not a valid Guardian ID Account.");
        }
        if(hasAccountInt < -1){
            throw new Exception("Not a valid Guardian ID Account.");
        }
        if (hasAccountInt != -1){
            if (this.userHandler.getGuardianByID(hasAccountInt) == null){
                throw new Exception("Not a valid Guardian ID Account.");
            }
        }
    }

    public boolean enterCreditDetails(String creditNumber, String expirationMonth, String expirationYear, String limit) throws Exception {
        int ccNumber;
        try {
            ccNumber = Integer.parseInt(creditNumber);
        } catch(Exception e){
            throw new Exception("Not a valid credit number.");
        }
        if(ccNumber < 0){
            throw new Exception("Not a valid credit number.");
        }

//        if (expirationMonth.length() != 2 || expirationYear.length() != 2){
//            throw new Exception("Not a valid credit expiration year.");
//        }

        int expMonth;
        try {
            expMonth = Integer.parseInt(expirationMonth);
        } catch(Exception e){
            throw new Exception("Not a valid credit expiration month.");
        }
        if(expMonth < 1 || expMonth > 12){
            throw new Exception("Not a valid credit expiration month.");
        }

        int expYear;
        try {
            expYear = Integer.parseInt(expirationYear);
        } catch(Exception e){
            throw new Exception("Not a valid credit expiration year.");
        }
        if(expYear < 0){
            throw new Exception("Not a valid credit expiration year.");
        }


        float gLimit;
        try {
            gLimit = Float.parseFloat(limit);
        } catch(Exception e){
            throw new Exception("Not a valid credit limit.");
        }
        if(gLimit < 0){
            throw new Exception("Not a valid credit limit.");
        }

        return this.paymentHandler.isValidCredit(ccNumber, expMonth, expYear, limit);
    }


    public void ManageTicket()
    {

    }

    public boolean AddRide(Device device, eTicket ticket)
    {
        float devicePrice = device.getPrice();
        boolean outOfBalance = ticket.isOutOfBalance(devicePrice);
        if (outOfBalance){
            return false;
        }
        else{
            Entrance newEntry = new Entrance(device,ticket);
            systemObjects.add(newEntry);
            ticket.addEntry(device,newEntry);
            return true;
        }
    }

    public void RemoveRide(Device device, eTicket ticket)
    {
        Entrance entryToRemove = ticket.removeEntry(device);
        systemObjects.remove(entryToRemove);
    }

    public String ExitPark(String name)
    {
        Child child = this.userHandler.getChildById(name);
        if(!systemObjects.contains(child)) return "This child is not in the system.";

        systemObjects.removeIf(obj -> obj instanceof Child && obj == child);
        eTicket childTicket = child.getTicket();
        for(ArrayList<Entrance> alE: childTicket.getEntranceTable().values()){
            for(Entrance e: alE){
                systemObjects.removeIf(obj -> obj instanceof Entrance && obj == e);
            }
        }
        systemObjects.removeIf(obj -> obj instanceof eTicket && obj == childTicket);
        String confirmationMsg = this.userHandler.exitChild(child);
        return confirmationMsg;
    }

    public void Exit()
    {
        System.exit(0);
    }

    public Child getChildById(String childID) {
        return this.userHandler.getChildById(childID);
    }

    public ArrayList<Device> getSuitableDevices(Child child) {
        return this.park.getSuitableDevices(child);
    }

    public void registerNewChild(String childId, String childName, String childAge, String creditNumber, String expirationMonth, String expirationYear, String limit, int makeAccount) {

        this.userHandler.registerNewChild(Integer.parseInt(childId), childName, Integer.parseInt(childAge), Integer.parseInt(creditNumber), Integer.parseInt(expirationMonth), Integer.parseInt(expirationYear), Float.parseFloat(limit), makeAccount);
    }

    public void registerMeasurement(String childName, String childHeight, String childWeight) throws Exception {

        float height;
        try {
            height = Float.parseFloat(childHeight);
        } catch (Exception e) {
            throw new Exception("Not a valid height.");
        }
        if (height < 0) {
            throw new Exception("Not a valid credit height.");
        }

        float weight;
        try {
            weight = Float.parseFloat(childWeight);
        } catch (Exception e) {
            throw new Exception("Not a valid weight.");
        }
        if (weight < 0) {
            throw new Exception("Not a valid credit weight.");
        }

        this.userHandler.addMeasurement(childName, height, weight);
    }
    /**
     * Asks from payment handle to handle the payment.
     * @param billToPay
     * @param creditCard
     * @return
     */
    public String chargeBill(Float billToPay, CreditCard creditCard) {
        return this.paymentHandler.chargeBill(billToPay, creditCard);
    }

    public void EnterToDeviceHandler(Device device, eTicket ticket) {
        ticket.setLocation(device.getName());
    }

    public void ExitFromDeviceHandler(Device device, eTicket ticket, Entrance entry) {
        if(device.isBroken()){
            // do something
        }
        else{
            ticket.removeUsedEntry(entry,device);
            systemObjects.remove(entry);
        }

    }

    public void addDeviceToPark(Device device) {
        systemObjects.add(device);
        this.park.setDevices(device.getName(),device);
    }
}

