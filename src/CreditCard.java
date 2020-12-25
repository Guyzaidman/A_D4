import java.util.ArrayList;
import java.util.Date;

public class CreditCard {
    private int creditNumber;
    private Date expirationDate;
    private ArrayList<eTicket> tickets;
    private GuardianAccount guardianAccount;

    public CreditCard(int creditNumber, Date expirationDate) {
        this.creditNumber = creditNumber;
        this.expirationDate = expirationDate;
        tickets = new ArrayList<>();
        this.guardianAccount = null;
    }

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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
