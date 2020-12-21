public class Device {
    private int ID;
    private String name;
    private ePark park;
    private int minAge;
    private int minHeight;
    private int minWeight;
    private boolean isBroken;

    public Device(int ID, String name, ePark park, int minAge, int minHeight, int minWeight) {
        this.ID = ID;
        this.name = name;
        this.park = park;
        this.minAge = minAge;
        this.minHeight = minHeight;
        this.minWeight = minWeight;
        this.isBroken = false;
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

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinWeight() {
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
}
