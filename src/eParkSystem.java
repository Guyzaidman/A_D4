import java.util.ArrayList;
import java.util.Date;


public class eParkSystem {

    private UserHandler userHandler;
    private PaymentHandler paymentHandler;
    public static ArrayList<Object> systemObjects = new ArrayList<>();

    public eParkSystem() {
        this.userHandler = new UserHandler(this);
        this.paymentHandler = new PaymentHandler(this);

    }

    public UserHandler getUserHandler() {
        return userHandler;
    }

    public PaymentHandler getPaymentHandler() {
        return paymentHandler;
    }

    public void RegisterChild(int ID, String name, int age, int creditNumber, Date expirationDate, float maxAmount)
    {
        boolean isValid = this.userHandler.isValid(creditNumber, expirationDate, maxAmount);
        if (isValid)
        {
//            CreditCard creditCard = new CreditCard(creditNumber, expirationDate);
//            systemObjects.add(creditCard);
//            GuardianAccount guardianAccount = this.userHandler.createGuardianAccount(creditCard);
//            systemObjects.add(guardianAccount);
//            Child child = this.userHandler.createChild(ID, name, age, guardianAccount);
//            systemObjects.add(child);
//            eTicket eTicket = this.userHandler.createETicket(creditCard, child, maxAmount);
//            systemObjects.add(eTicket);

        }
    }


    public void ManageTicket()
    {

    }

    public void AddRide()
    {

    }

    public void RemoveRide()
    {

    }

    public String ExitPark(String name)
    {
        Child child = this.userHandler.getChildById(name);
        if(!systemObjects.contains(child)) return "This child is not in the system.";
        String confirmationMsg = this.userHandler.exitChild(child);
        systemObjects.removeIf(obj -> obj instanceof Child && obj == child);
        eTicket childTicket = child.getTicket();
        systemObjects.removeIf(obj -> obj instanceof eTicket && obj == childTicket);
        return confirmationMsg;
    }

    public void Exit()
    {
        System.exit(0);
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
}

