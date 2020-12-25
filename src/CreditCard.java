import java.util.ArrayList;
import java.util.Date;

public class CreditCard {
    private int creditNumber;
    private int expYear;
    private int expMonth;
    private ArrayList<eTicket> tickets;
    private GuardianAccount guardianAccount;

    public CreditCard(int creditNumber, int expYear, int expMonth) {
        this.creditNumber = creditNumber;
        this.expYear = expYear;
        this.expMonth = expMonth;
        tickets = new ArrayList<>();
        this.guardianAccount = null;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public ArrayList<eTicket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<eTicket> tickets) {
        this.tickets = tickets;
    }

    public GuardianAccount getGuardianAccount() {
        return guardianAccount;
    }

    public void setGuardianAccount(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
    }
}
