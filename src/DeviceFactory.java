public class DeviceFactory {

    public DeviceFactory(){

    }

    public Device buildDevice(String deviceName, boolean isExtreme, ePark park,  int minAge, float minHeight, float minWeight, float price){
        if(isExtreme){
            return new ExtremeDevice(deviceName, park, minAge, minHeight, minWeight, price);
        }
        else {
            return new Device(deviceName, park, minAge, minHeight, minWeight, price);
        }
    }
}
