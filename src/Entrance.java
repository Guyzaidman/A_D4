public class Entrance {
    private int ID;
    private Device device;
    private eTicket ticket;
    private boolean inUse;

    public Entrance(int ID, Device device, eTicket ticket) {
        this.ID = ID;
        this.device = device;
        this.ticket = ticket;
        this.inUse = false;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public eTicket getTicket() {
        return ticket;
    }

    public void setTicket(eTicket ticket) {
        this.ticket = ticket;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
