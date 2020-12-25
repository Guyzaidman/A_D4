public class Entrance {
    private Device device;
    private eTicket ticket;
    private boolean inUse;

    public Entrance(Device device, eTicket ticket) {
        this.device = device;
        this.ticket = ticket;
        this.inUse = false;
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
