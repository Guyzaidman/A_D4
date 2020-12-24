public class PaymentHandler {
    private eParkSystem parkSystem;
    private CreditCompany creditCompany;

    public PaymentHandler(eParkSystem parkSystem) {
        this.parkSystem = parkSystem;
        this.creditCompany = new CreditCompany(this);
    }


//    public ePark getPark() {
//        return park;
//    }
//
//    public void setPark(ePark park) {
//        this.park = park;
//    }

    public CreditCompany getCreditCompany() {
        return creditCompany;
    }

    public void setCreditCompany(CreditCompany creditCompany) {
        this.creditCompany = creditCompany;
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
