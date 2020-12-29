public class Entrance {
    private Device device;
    private eTicket ticket;
    private boolean inUse;

    public Entrance(Device device, eTicket ticket) {
        this.device = device;
        this.ticket = ticket;
        this.inUse = false;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
