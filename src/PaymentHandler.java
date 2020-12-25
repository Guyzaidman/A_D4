public class PaymentHandler {

    private eParkSystem park;
    private CreditCompany creditCompany;

    public PaymentHandler(eParkSystem eps) {
        this.park = eps;
        this.creditCompany = new CreditCompany(this);
    }
  
    public eParkSystem getPark() {
        return park;
    }

    public void setPark(eParkSystem park) {
        this.park = park;
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
    /**
     * Communicates with the credit company and charges the credit card through the company.
     * @param billToPay
     * @param creditCard
     * @return
     */
    public String chargeBill(Float billToPay, CreditCard creditCard) {
        return creditCompany.chargeBill(billToPay, creditCard);
    }
}
