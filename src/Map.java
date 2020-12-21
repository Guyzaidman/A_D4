import java.util.ArrayList;

public class Map {
    private int ID;
    private GuardianAccount guardianAccount;
    private ArrayList<eTicket> eTickets;

    public Map(int ID, GuardianAccount guardianAccount) {
        this.ID = ID;
        this.guardianAccount = guardianAccount;
        this.eTickets = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public GuardianAccount getGuardianAccount() {
        return guardianAccount;
    }

    public void setGuardianAccount(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
    }

    public ArrayList<eTicket> geteTickets() {
        return eTickets;
    }

    public void seteTickets(ArrayList<eTicket> eTickets) {
        this.eTickets = eTickets;
    }
}
