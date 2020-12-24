public class PaymentHandler {
    private int ID;

    public eParkSystem getPark() {
        return park;
    }

    public void setPark(eParkSystem park) {
        this.park = park;
    }

    private eParkSystem park;
    private CreditCompany creditCompany;

    public PaymentHandler(eParkSystem eps) {
        this.park = eps;
        this.creditCompany = new CreditCompany(this);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public CreditCompany getCreditCompany() {
        return creditCompany;
    }

    public void setCreditCompany(CreditCompany creditCompany) {
        this.creditCompany = creditCompany;
    }

    public boolean isValidCredit(int ccNumber, int expMonth, int expYear, String limit) {
        return true;
    }

}
