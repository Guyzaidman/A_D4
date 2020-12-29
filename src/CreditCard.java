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

    public void setGuardianAccount(GuardianAccount guardianAccount) {
        this.guardianAccount = guardianAccount;
    }
}
