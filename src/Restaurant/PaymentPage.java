package Restaurant;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PaymentPage {

    private JFrame frame;
    private ArrayList<String> items;
    private double totalPrice;

    /**
     * Create the application.
     */
    public PaymentPage(ArrayList<String> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Choose Payment Method:");
        lblNewLabel.setBounds(128, 40, 182, 14);
        frame.getContentPane().add(lblNewLabel);

        JButton btnCash = new JButton("Cash");
        btnCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle cash payment logic here (e.g., open cash payment dialog)
                handleCashPayment();
            }
        });
        btnCash.setBounds(115, 100, 89, 23);
        frame.getContentPane().add(btnCash);

        JButton btnCard = new JButton("Card");
        btnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle card payment logic here (e.g., open card payment dialog)
                handleCardPayment();
            }
        });
        btnCard.setBounds(225, 100, 89, 23);
        frame.getContentPane().add(btnCard);
    }

    /**
     * Method to handle cash payment.
     */
    private void handleCashPayment() {
        // Implement logic for cash payment
        // For example, show a dialog to input cash amount and process payment
        System.out.println("Processing Cash Payment");
        // You can add further logic here as per your application's requirements
    }

    /**
     * Method to handle card payment.
     */
    private void handleCardPayment() {
        // Implement logic for card payment
        // For example, show a dialog to input card details and process payment
        System.out.println("Processing Card Payment");
        // You can add further logic here as per your application's requirements
    }

    /**
     * Method to make the frame visible.
     */
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
}
