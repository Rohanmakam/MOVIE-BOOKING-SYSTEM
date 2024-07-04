import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingUI {
    private JFrame frame;
    private JTextField userNameField;
    private JTextField userEmailField;
    private JTextField movieTitleField;
    private JTextField movieGenreField;
    private JTextField movieDurationField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField numberOfTicketsField;
    private JButton submitButton;
    private JLabel statusLabel;

    public BookingUI() {
        frame = new JFrame("Movie Booking System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(11, 2));

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

        submitButton = new JButton("Submit");
        frame.add(submitButton);

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusLabel);

        // Set background colors for input fields and labels
        userNameField.setBackground(Color.WHITE);
        userEmailField.setBackground(Color.WHITE);
        movieTitleField.setBackground(Color.WHITE);
        movieGenreField.setBackground(Color.WHITE);
        movieDurationField.setBackground(Color.WHITE);
        dateField.setBackground(Color.WHITE);
        timeField.setBackground(Color.WHITE);
        numberOfTicketsField.setBackground(Color.WHITE);

        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit() {
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

    public static void main(String[] args) {
        // Use Event Dispatch Thread for Swing applications
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookingUI();
            }
        });
    }
}
