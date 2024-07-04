import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public List<Booking> getBookingsByUser(User user) {
        List<Booking> userBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getUser().equals(user)) {
                userBookings.add(booking);
            }
        }
        return userBookings;
    }

    public List<Booking> getBookingsByMovie(Movie movie) {
        List<Booking> movieBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getMovie().equals(movie)) {
                movieBookings.add(booking);
            }
        }
        return movieBookings;
    }
}
