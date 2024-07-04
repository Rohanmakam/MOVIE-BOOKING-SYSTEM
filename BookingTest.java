import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private User user;
    private Movie movie;
    private Booking booking;

    @BeforeEach
    public void setUp() {
        user = new User("john_doe", "password123", "john@example.com");
        movie = new Movie("Inception", "Sci-Fi", 148);
        booking = new Booking(user, movie, "2024-07-05", "18:00", 2);
    }

    @Test
    public void testGetUser() {
        assertEquals(user, booking.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new User("jane_doe", "password456", "jane@example.com");
        booking.setUser(newUser);
        assertEquals(newUser, booking.getUser());
    }

    @Test
    public void testGetMovie() {
        assertEquals(movie, booking.getMovie());
    }

    @Test
    public void testSetMovie() {
        Movie newMovie = new Movie("The Matrix", "Action", 136);
        booking.setMovie(newMovie);
        assertEquals(newMovie, booking.getMovie());
    }

    @Test
    public void testGetDate() {
        assertEquals("2024-07-05", booking.getDate());
    }

    @Test
    public void testSetDate() {
        String newDate = "2024-07-06";
        booking.setDate(newDate);
        assertEquals(newDate, booking.getDate());
    }

    @Test
    public void testGetTime() {
        assertEquals("18:00", booking.getTime());
    }

    @Test
    public void testSetTime() {
        String newTime = "20:00";
        booking.setTime(newTime);
        assertEquals(newTime, booking.getTime());
    }

    @Test
    public void testGetNumberOfTickets() {
        assertEquals(2, booking.getNumberOfTickets());
    }

    @Test
    public void testSetNumberOfTickets() {
        int newNumberOfTickets = 4;
        booking.setNumberOfTickets(newNumberOfTickets);
        assertEquals(newNumberOfTickets, booking.getNumberOfTickets());
    }
}
