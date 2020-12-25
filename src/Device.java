public class Device {
    private int ID;
    private String name;
    private ePark park;
    private int minAge;
    private float minHeight;
    private float minWeight;
    private boolean isBroken;
    private float price;

    public Device(int ID, String name, ePark park, int minAge, float minHeight, float minWeight, float price) {
        this.ID = ID;
        this.name = name;
        this.park = park;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.minWeight = minWeight;
        this.isBroken = false;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ePark getPark() {
        return park;
    }

    public void setPark(ePark park) {
        this.park = park;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public float getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public float getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
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


}
