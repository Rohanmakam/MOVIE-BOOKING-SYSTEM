import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentUI extends JFrame {
    private JTextField userField;
    private JTextField bookingField;
    private JTextField amountField;
    private JTextField paymentMethodField;
    private JButton submitButton;

    public PaymentUI() {
        setTitle("Payment Form");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("User:"));
        userField = new JTextField();
        panel.add(userField);

        panel.add(new JLabel("Booking:"));
        bookingField = new JTextField();
        panel.add(bookingField);

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        panel.add(new JLabel("Payment Method:"));
        paymentMethodField = new JTextField();
        panel.add(paymentMethodField);

        submitButton = new JButton("Submit");
        panel.add(submitButton);

        add(panel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assuming User and Booking are classes with appropriate constructors
                User user = new User(userField.getText());
                Booking booking = new Booking(bookingField.getText());
                double amount = Double.parseDouble(amountField.getText());
                String paymentMethod = paymentMethodField.getText();

                Payment payment = new Payment(user, booking, amount, paymentMethod);
                // Add code here to handle the payment, e.g., saving to database
                JOptionPane.showMessageDialog(null, "Payment Submitted Successfully!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaymentUI().setVisible(true);
            }
        });
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    // Add other fields and methods as required
}

class Booking {
    private String details;

    public Booking(String details) {
        this.details = details;
    }

    // Add other fields and methods as required
}

