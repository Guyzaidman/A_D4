import java.util.ArrayList;
import java.util.Date;


public class eParkSystem {

    private UserHandler userHandler;
    private PaymentHandler paymentHandler;
    private ePark park;
    public static ArrayList<Object> systemObjects = new ArrayList<>();

    public eParkSystem() {
        this.userHandler = new UserHandler();
        this.paymentHandler = new PaymentHandler();
        this.park = new ePark(1,this);

    }

    public void RegisterChild(int ID, String name, int age, int creditNumber, Date expirationDate, float maxAmount)
    {
        boolean isValid = this.userHandler.isValid(creditNumber, expirationDate, maxAmount);
        if (isValid)
        {
            CreditCard creditCard = new CreditCard(creditNumber, expirationDate);
            systemObjects.add(creditCard);
            GuardianAccount guardianAccount = this.userHandler.createGuardianAccount(creditCard);
            systemObjects.add(guardianAccount);
            Child child = this.userHandler.createChild(ID, name, age, guardianAccount);
            systemObjects.add(child);
            eTicket eTicket = this.userHandler.createETicket(creditCard, child, maxAmount);
            systemObjects.add(eTicket);

        }
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

    public void ExitPark(String name)
    {

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
}

