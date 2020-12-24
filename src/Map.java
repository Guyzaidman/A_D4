import java.util.ArrayList;

public class Map {
    private GuardianAccount guardianAccount;
    private ArrayList<eTicket> eTickets;

    public Map(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
        this.eTickets = new ArrayList<>();
        this.guardianAccount.setMap(this);
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

    public void addETicket(eTicket eTicket) {
        this.eTickets.add(eTicket);
    }
}
