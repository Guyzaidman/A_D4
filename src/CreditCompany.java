public class CreditCompany {
    private PaymentHandler paymentHandler;

    public CreditCompany(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    public PaymentHandler getPaymentHandler() {
        return paymentHandler;
    }

    public void setPaymentHandler(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    /**
     * Charges the given bill -> billToPay from given credit card -> creditCard
     * @param billToPay bill to charge
     * @param creditCard credit card to charge from.
     * @return A message that the payment is confirmed.
     */
    public String chargeBill(Float billToPay, CreditCard creditCard) {
        // Company charges the credit card with given amount..
        return "Payment confirmed.";
    }
}
