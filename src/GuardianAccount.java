import java.util.HashMap;

public class GuardianAccount {
    private static int ID = 0;
    private int id;
    private HashMap<String,Child> children;
    private CreditCard creditCard;
    private Map map;
    private UserHandler userHandler;


    public GuardianAccount(CreditCard creditCard, UserHandler userHandler) {
        this.id = GuardianAccount.ID;
        GuardianAccount.ID++;
        this.creditCard = creditCard;
        this.creditCard.setGuardianAccount(this);
        this.map = null;
        this.children = new HashMap<>();
        this.userHandler = userHandler;
    }

    public int getID() {
        return this.id;
    }

    public HashMap<String, Child> getChildren() {
        return children;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void addChild(Child child) {
        this.children.put(child.getName(), child);
    }

    public Child getChildById(String name) {
        return this.children.get(name);
    }

    public Float calculateBill(Child child) {
        return child.calculateBill();
    }

    public void removeChild(Child child) {
        this.children.remove(child.getName());
        child.setGuardianAccount(null); // child has no guardian when he exists the park??

    }
}
