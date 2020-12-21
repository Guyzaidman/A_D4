public class CreditCompany {
    private int ID;
    private PaymentHandler paymentHandler;

    public CreditCompany(int ID, PaymentHandler paymentHandler) {
        this.ID = ID;
        this.paymentHandler = paymentHandler;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public PaymentHandler getPaymentHandler() {
        return paymentHandler;
    }

    public void setPaymentHandler(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }
}
