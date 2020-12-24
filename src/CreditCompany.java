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
}
