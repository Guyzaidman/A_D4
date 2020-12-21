public class PaymentHandler {
    private int ID;
    private ePark park;
    private CreditCompany creditCompany;

    public PaymentHandler(int ID, ePark park, CreditCompany creditCompany) {
        this.ID = ID;
        this.park = park;
        this.creditCompany = creditCompany;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ePark getPark() {
        return park;
    }

    public void setPark(ePark park) {
        this.park = park;
    }

    public CreditCompany getCreditCompany() {
        return creditCompany;
    }

    public void setCreditCompany(CreditCompany creditCompany) {
        this.creditCompany = creditCompany;
    }
}
