public class Device {
    private String name;
    private ePark park;
    private int minAge;
    private float minHeight;
    private float minWeight;
    private boolean isBroken;
    private float price;

    public Device(String name, ePark park, int minAge, float minHeight, float minWeight, float price) {
        this.name = name;
        this.park = park;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.minWeight = minWeight;
        this.isBroken = false;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public float getPrice() { return price; }

    public boolean isSuitable(int childAge, float childWeight, float childHeight) {
        if (childAge < minAge) return false;
        if (childWeight < minWeight) return false;
        if (childHeight < minHeight) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Price: " + this.price;
    }

    public void gotEnterToByeTicket(eTicket ticket) {
        this.park.DeviceGotEnter(this,ticket);
    }

    public void gotExitByeTicket(eTicket ticket, Entrance entry) {
        this.park.gotExitFromDevice(this,ticket,entry);
    }
}
