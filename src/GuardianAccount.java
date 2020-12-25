import java.util.HashMap;

public class GuardianAccount {
    private int ID;
    private HashMap<String,Child> children;
    private CreditCard creditCard;
    private Map map;
    private UserHandler userHandler;

    public GuardianAccount(int ID, CreditCard creditCard, Map map, UserHandler userHandler) {
        this.ID = ID;
        this.creditCard = creditCard;
        this.map = map;
        this.children = new HashMap<>();
        this.userHandler = userHandler;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public HashMap<String, Child> getChildren() {
        return children;
    }

    public void setChildren(HashMap<String, Child> children) {
        this.children = children;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public UserHandler getUserHandler() {
        return userHandler;
    }

    public void setUserHandler(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    public Child getChildById(String name) {
        return this.children.get(name);
    }
}
