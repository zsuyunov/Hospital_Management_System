package Restaurant;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class BillingPage {

    private JFrame frame;
    private JTextArea billArea;
    private ArrayList<String> items;
    private double totalPrice;

    /**
     * Create the application.
     */
    public BillingPage(ArrayList<String> items, double totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Billing Page");
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(160, 10, 200, 50);
        frame.getContentPane().add(lblNewLabel);

        billArea = new JTextArea();
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        billArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(billArea);
        scrollPane.setBounds(30, 70, 430, 250);
        frame.getContentPane().add(scrollPane);

        displayBill();
    }

    /**
     * Method to display the bill with selected items and total price.
     */
    private void displayBill() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item\t\tPrice\n");
        sb.append("--------------------------------\n");
        for (String item : items) {
            sb.append(item).append("\n");
        }
        sb.append("--------------------------------\n");
        sb.append(String.format("Total Price:\t£%.2f\n", totalPrice));

        billArea.setText(sb.toString());
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
