package Restaurant;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;

public class Menupage {

    private JFrame frame;
    private ArrayList<String> items; // List to store item names and prices
    private double totalPrice = 0.0;
    private JLabel totalLabel;
    private JTextArea billArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menupage window = new Menupage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Menupage() {
        initialize();
    }

    private void initialize() {
        items = new ArrayList<>();
        frame = new JFrame();
        frame.setBounds(0, 0, 1450, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Restaurant Menu Card");
        lblNewLabel.setBackground(new Color(0, 128, 128));
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        lblNewLabel.setBounds(131, 0, 668, 73);
        frame.getContentPane().add(lblNewLabel);

        // Adding buttons for each menu item
        addItemButton("Chicken Soup", 7.00, 35, 350);
        addItemButton("Vegetable Clear Soup", 5.00, 291, 350);
        addItemButton("Egg Sandwich", 7.00, 520, 350);
        addItemButton("Chicken Sandwich", 8.00, 793, 350);

        // Total price label
        totalLabel = new JLabel("Total Price: £0.00");
        totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        totalLabel.setBounds(35, 400, 300, 30);
        frame.getContentPane().add(totalLabel);

        // Text area to display the bill
        billArea = new JTextArea();
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        billArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(billArea);
        scrollPane.setBounds(35, 450, 400, 200);
        frame.getContentPane().add(scrollPane);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 600, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginpage loginPage = new loginpage();
                loginPage.setVisible(true);
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnBack);

        // Checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(350, 400, 100, 30);
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BillingPage billingPage = new BillingPage(items, totalPrice);
                billingPage.setVisible(true);
                frame.dispose(); // Close the menu page
            }
        });
        frame.getContentPane().add(checkoutButton);

        // Add existing labels and image icons here
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 212359.png"));
        lblNewLabel_3.setForeground(new Color(0, 128, 128));
        lblNewLabel_3.setBounds(10, 862, 252, 0);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBounds(213, 112, 153, 90);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 212359.png"));
        lblNewLabel_5.setBounds(40, 100, 241, 161);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 212707.png"));
        lblNewLabel_6.setBounds(305, 100, 194, 161);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 212902.png"));
        lblNewLabel_7.setBounds(520, 100, 252, 161);
        frame.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 212918.png"));
        lblNewLabel_8.setBounds(793, 100, 213, 161);
        frame.getContentPane().add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setBounds(816, 174, 45, 13);
        frame.getContentPane().add(lblNewLabel_9);

        JLabel lblNewLabel_11 = new JLabel("Chicken Soup");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_11.setForeground(new Color(0, 0, 0));
        lblNewLabel_11.setBackground(new Color(0, 0, 0));
        lblNewLabel_11.setBounds(35, 253, 231, 55);
        frame.getContentPane().add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("Price : £7");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_12.setBounds(35, 297, 247, 30);
        frame.getContentPane().add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("Vegetable Clear Soup");
        lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_13.setBounds(291, 253, 213, 47);
        frame.getContentPane().add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("Price : £5");
        lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_14.setBounds(292, 301, 231, 23);
        frame.getContentPane().add(lblNewLabel_14);

        JLabel lblNewLabel_15 = new JLabel("Egg Sandwich");
        lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_15.setBounds(520, 258, 268, 45);
        frame.getContentPane().add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel("Price : £7");
        lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_16.setBounds(525, 297, 289, 30);
        frame.getContentPane().add(lblNewLabel_16);
        
        JLabel lblNewLabel_1 = new JLabel("Chicken Sandwich");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(781, 271, 225, 30);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Price : £8");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(781, 297, 231, 36);
        frame.getContentPane().add(lblNewLabel_2);
    }

    private void addItemButton(String name, double price, int x, int y) {
        JButton button = new JButton(name);
        button.setBounds(x, y, 200, 30);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                items.add(name + " - £" + price);
                totalPrice += price;
                updateTotalLabel();
                updateBillArea();
            }
        });
        frame.getContentPane().add(button);
    }

    /**
     * Updates the total price label
     */
    protected void updateTotalLabel() {
        totalLabel.setText(String.format("Total Price: £%.2f", totalPrice));
    }

    /**
     * Updates the bill area with the list of items
     */
    protected void updateBillArea() {
        StringBuilder billText = new StringBuilder();
        for (String item : items) {
            billText.append(item).append("\n");
        }
        billArea.setText(billText.toString());
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
