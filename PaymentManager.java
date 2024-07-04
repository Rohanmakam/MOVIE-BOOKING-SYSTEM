import java.util.ArrayList;
import java.util.List;

public class PaymentManager {
    private List<Payment> payments = new ArrayList<>();

    public void processPayment(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> getPaymentsByUser(User user) {
        List<Payment> userPayments = new ArrayList<>();
        for (Payment payment : payments) {
            if (payment.getUser().equals(user)) {
                userPayments.add(payment);
            }
        }
        return userPayments;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
