import java.util.ArrayList;
import java.util.Date;


public class eParkSystem {

    private UserHandler userHandler;
    private PaymentHandler paymentHandler;
    public static ArrayList<Object> systemObjects = new ArrayList<>();

    public eParkSystem() {
        this.userHandler = new UserHandler();
        this.paymentHandler = new PaymentHandler();

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

    public void AddRide()
    {

    }

    public void RemoveRide()
    {

    }

    public void ExitPark(String name)
    {

    }

    public void Exit()
    {
        System.exit(0);
    }
}

