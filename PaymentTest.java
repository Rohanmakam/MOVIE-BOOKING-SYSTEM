import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {

    @Test
    public void testConstructorAndGetters() {
        User user = new User("John Doe", "johndoe@example.com");
        Booking booking = new Booking("BookingID123", "Room A", "2024-07-04");
        double amount = 100.0;
        String paymentMethod = "Credit Card";

        Payment payment = new Payment(user, booking, amount, paymentMethod);

        assertEquals(user, payment.getUser());
        assertEquals(booking, payment.getBooking());
        assertEquals(amount, payment.getAmount(), 0.001); // Using delta for double comparison
        assertEquals(paymentMethod, payment.getPaymentMethod());
    }

    @Test
    public void testSetters() {
        User user = new User("Jane Smith", "janesmith@example.com");
        Booking booking = new Booking("BookingID456", "Room B", "2024-07-05");
        double amount = 150.0;
        String paymentMethod = "PayPal";

        Payment payment = new Payment(null, null, 0.0, null);

        payment.setUser(user);
        payment.setBooking(booking);
        payment.setAmount(amount);
        payment.setPaymentMethod(paymentMethod);

        assertEquals(user, payment.getUser());
        assertEquals(booking, payment.getBooking());
        assertEquals(amount, payment.getAmount(), 0.001); // Using delta for double comparison
        assertEquals(paymentMethod, payment.getPaymentMethod());
    }
}
