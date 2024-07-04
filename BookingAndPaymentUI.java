import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingAndPaymentUI {
    private JFrame frame;
    private JTextField userNameField;
    private JTextField userEmailField;
    private JTextField movieTitleField;
    private JTextField movieGenreField;
    private JTextField movieDurationField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField numberOfTicketsField;
    private JButton submitBookingButton;
    private JLabel statusLabel;

    private JTextField amountField;
    private JTextField paymentMethodField;
    private JButton submitPaymentButton;

    public BookingAndPaymentUI() {
        frame = new JFrame("Movie Booking and Payment System");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(14, 2));

        // Booking Section
        frame.add(new JLabel("User Name:"));
        userNameField = new JTextField();
        frame.add(userNameField);

        frame.add(new JLabel("User Email:"));
        userEmailField = new JTextField();
        frame.add(userEmailField);

        frame.add(new JLabel("Movie Title:"));
        movieTitleField = new JTextField();
        frame.add(movieTitleField);

        frame.add(new JLabel("Movie Genre:"));
        movieGenreField = new JTextField();
        frame.add(movieGenreField);

        frame.add(new JLabel("Movie Duration (minutes):"));
        movieDurationField = new JTextField();
        frame.add(movieDurationField);

        frame.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        frame.add(dateField);

        frame.add(new JLabel("Time (HH:MM):"));
        timeField = new JTextField();
        frame.add(timeField);

        frame.add(new JLabel("Number of Tickets:"));
        numberOfTicketsField = new JTextField();
        frame.add(numberOfTicketsField);

        submitBookingButton = new JButton("Submit Booking");
        frame.add(submitBookingButton);

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusLabel);

        // Payment Section
        frame.add(new JLabel("Amount:"));
        amountField = new JTextField();
        frame.add(amountField);

        frame.add(new JLabel("Payment Method:"));
        paymentMethodField = new JTextField();
        frame.add(paymentMethodField);

        submitPaymentButton = new JButton("Submit Payment");
        frame.add(submitPaymentButton);

        frame.setVisible(true);

        submitBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitBooking();
            }
        });

        submitPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmitPayment();
            }
        });
    }

    private void handleSubmitBooking() {
        String userName = userNameField.getText();
        String userEmail = userEmailField.getText();
        String movieTitle = movieTitleField.getText();
        String movieGenre = movieGenreField.getText();
        int movieDuration = Integer.parseInt(movieDurationField.getText());
        String date = dateField.getText();
        String time = timeField.getText();
        int numberOfTickets = Integer.parseInt(numberOfTicketsField.getText());

        User user = new User(userName, userEmail);
        Movie movie = new Movie(movieTitle, movieGenre, movieDuration);
        Booking booking = new Booking(user, movie, date, time, numberOfTickets);

        statusLabel.setText("Booking confirmed for " + booking.getUser().getName() + "!");
    }

    private void handleSubmitPayment() {
        String amount = amountField.getText();
        String paymentMethod = paymentMethodField.getText();

        // Assuming the same user and booking for simplicity
        String userName = userNameField.getText();
        String userEmail = userEmailField.getText();
        User user = new User(userName, userEmail);
        String movieTitle = movieTitleField.getText();
        String movieGenre = movieGenreField.getText();
        int movieDuration = Integer.parseInt(movieDurationField.getText());
        String date = dateField.getText();
        String time = timeField.getText();
        int numberOfTickets = Integer.parseInt(numberOfTicketsField.getText());
        Booking booking = new Booking(user, new Movie(movieTitle, movieGenre, movieDuration), date, time, numberOfTickets);

        double paymentAmount = Double.parseDouble(amount);
        Payment payment = new Payment(user, booking, paymentAmount, paymentMethod);

        // Add code here to handle the payment, e.g., saving to database
        JOptionPane.showMessageDialog(null, "Payment Submitted Successfully!");
    }

    public static void main(String[] args) {
        // Use Event Dispatch Thread for Swing applications
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookingAndPaymentUI();
            }
        });
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }
}

class Booking {
    private User user;
    private Movie movie;
    private String date;
    private String time;
    private int numberOfTickets;

    public Booking(User user, Movie movie, String date, String time, int numberOfTickets) {
        this.user = user;
        this.movie = movie;
        this.date = date;
        this.time = time;
        this.numberOfTickets = numberOfTickets;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}

class Payment {
    private User user;
    private Booking booking;
    private double amount;
    private String method;

    public Payment(User user, Booking booking, double amount, String method) {
        this.user = user;
        this.booking = booking;
        this.amount = amount;
        this.method = method;
    }
}
