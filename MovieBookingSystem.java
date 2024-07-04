public class MovieBookingSystem {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        MovieManager movieManager = new MovieManager();
        BookingManager bookingManager = new BookingManager();
        PaymentManager paymentManager = new PaymentManager();

        // Example Usage
        User user = new User("john_doe", "password123", "john@example.com");
        userManager.registerUser(user);

        Movie movie = new Movie("Inception", "Sci-Fi", 148);
        movieManager.addMovie(movie);

        Booking booking = new Booking(user, movie, "2024-07-05", "18:00", 2);
        bookingManager.addBooking(booking);

        Payment payment = new Payment(user, booking, 20.00, "Credit Card");
        paymentManager.processPayment(payment);

        System.out.println("User Registered: " + user.getUsername());
        System.out.println("Movie Added: " + movie.getTitle());
        System.out.println("Booking Created: " + booking.getMovie().getTitle() + " for " + booking.getUser().getUsername());
        System.out.println("Payment Processed: " + payment.getAmount() + " for " + payment.getUser().getUsername());
    }
}
