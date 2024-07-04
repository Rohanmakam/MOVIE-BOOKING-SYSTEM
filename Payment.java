public class Payment {
    private User user;
    private Booking booking;
    private double amount;
    private String paymentMethod;

    public Payment(User user, Booking booking, double amount, String paymentMethod) {
        this.user = user;
        this.booking = booking;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
