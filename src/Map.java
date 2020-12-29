import java.util.ArrayList;

public class Map {
    private GuardianAccount guardianAccount;
    private ArrayList<eTicket> eTickets;

    public Map(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
        this.eTickets = new ArrayList<>();
        this.guardianAccount.setMap(this);
    }

    public void addETicket(eTicket eTicket) {
        this.eTickets.add(eTicket);
    }
}
