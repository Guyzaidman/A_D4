public class PaymentHandler {

    private eParkSystem parkSystem;
    private CreditCompany creditCompany;

    public PaymentHandler(eParkSystem eps) {
        this.parkSystem = eps;
        this.creditCompany = new CreditCompany(this);
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
