public class ExtremeDevice extends Device{

    public ExtremeDevice(int ID, String name, ePark park, int minAge, float minHeight, float minWeight, float price) {
        super(ID, name, park, minAge, minHeight, minWeight, price);
    }

    @Override
    public String toString() {
        return super.toString() + " , Extreme device." ;
    }
}
