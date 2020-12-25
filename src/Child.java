public class Child {
    private int ID;
    private eTicket ticket;
    private String name;
    private int age;
    private float height;
    private float weight;
    private GuardianAccount guardianAccount;

    public Child(int ID, String name, int age, GuardianAccount guardianAccount) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.guardianAccount = guardianAccount;
        this.guardianAccount.addChild(this);
        this.ticket = null;
        this.weight = 0;
        this.height = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public eTicket getTicket() {
        return ticket;
    }

    public void setTicket(eTicket ticket) {
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public GuardianAccount getGuardianAccount() {
        return guardianAccount;
    }

    public void setGuardianAccount(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
    }

    public eTicket geteTicket() {
        return this.ticket;
    }
    public void enterToDevice(Device device){
        this.ticket.enterToDevice(device);
    }
    public void exitFromDevice(){
        this.ticket.exitFromDevice();
    }

    /**
     * Calculates the bill of the child.
     * @return the bill - Float
     */
    public Float calculateBill() {
        return this.ticket.calculateBill();
    }
}
