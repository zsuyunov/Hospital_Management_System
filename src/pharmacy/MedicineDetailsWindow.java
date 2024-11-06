package pharmacy;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MedicineDetailsWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblMedicineName;
    private JLabel lblComposition;
    private JLabel lblUses;
    private JLabel lblSideEffects;
    private JLabel lblImage;
    private JLabel expDate;
    private JLabel priceCol;
    private JLabel stockCol;

    private JButton btnCheckout, btnRemoveItem, btnAddItem;
    private JButton btnNewButton;

    public MedicineDetailsWindow(String[] medicineDetails, JFrame previousFrame) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMedicineName = new JLabel("Medicine Name: " + medicineDetails[0]);
        lblMedicineName.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMedicineName.setBackground(new Color(255, 255, 255));
        lblMedicineName.setBounds(309, 125, 351, 30);
        contentPane.add(lblMedicineName);

        lblComposition = new JLabel("Composition: " + medicineDetails[1]);
        lblComposition.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblComposition.setBounds(309, 181, 324, 30);
        contentPane.add(lblComposition);

        lblUses = new JLabel("Uses: " + medicineDetails[2]);
        lblUses.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUses.setBounds(309, 238, 283, 30);
        contentPane.add(lblUses);

        lblSideEffects = new JLabel("Side Effects: " + medicineDetails[3]);
        lblSideEffects.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSideEffects.setBounds(179, 296, 454, 30);
        contentPane.add(lblSideEffects);
        
        expDate = new JLabel("Expire Date: " + medicineDetails[5]);
        expDate.setFont(new Font("Tahoma", Font.BOLD, 12));
        expDate.setBounds(506, 356, 226, 30);
        contentPane.add(expDate);

        priceCol = new JLabel("Price: " + medicineDetails[6]);
        priceCol.setFont(new Font("Tahoma", Font.BOLD, 16));
        priceCol.setBounds(179, 356, 157, 30);
        contentPane.add(priceCol);
        
        stockCol = new JLabel("Stock: " + medicineDetails[7]);
        stockCol.setFont(new Font("Tahoma", Font.BOLD, 12));
        stockCol.setBounds(346, 356, 124, 30);
        contentPane.add(stockCol);

        lblImage = new JLabel();
        lblImage.setBounds(758, 65, 368, 449);
        try {
            URL url = new URL(medicineDetails[4]);
            ImageIcon icon = new ImageIcon(url);
            lblImage.setIcon(icon);
        } catch (Exception e) {
            lblImage.setText("Invalid URL");
        }
        contentPane.add(lblImage);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnAddItem.setBackground(new Color(0, 255, 0));
        btnAddItem.setBounds(432, 544, 300, 50);
        btnAddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to add item here
                JOptionPane.showMessageDialog(MedicineDetailsWindow.this, "Add Item clicked");
            }
        });
        contentPane.add(btnAddItem);

        btnRemoveItem = new JButton("Remove Item");
        btnRemoveItem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRemoveItem.setBackground(new Color(0, 255, 0));
        btnRemoveItem.setBounds(893, 623, 300, 50);
        btnRemoveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to remove item here
                JOptionPane.showMessageDialog(MedicineDetailsWindow.this, "Remove Item clicked");
            }
        });
        contentPane.add(btnRemoveItem);

        btnCheckout = new JButton("Checkout");
        btnCheckout.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCheckout.setBackground(new Color(0, 255, 0));
        btnCheckout.setBounds(893, 544, 300, 50);
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add checkout functionality here
                JOptionPane.showMessageDialog(MedicineDetailsWindow.this, "Checkout clicked");
            }
        });
        contentPane.add(btnCheckout);

        JButton btnBack = new JButton("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBackground(new Color(0, 255, 0));
        btnBack.setBounds(432, 623, 300, 50);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previousFrame.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBack);
        
        btnNewButton = new JButton("LOGOUT");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginScreen enter = new LoginScreen();
                setVisible(false);
                enter.setVisible(true);
        	}
        });
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setBounds(1129, 37, 104, 21);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture2.png"));
        lblNewLabel.setBounds(22, 10, 51, 61);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture3.png"));
        lblNewLabel_1.setBounds(104, 41, 160, 61);
        contentPane.add(lblNewLabel_1);
    }

    public static void main(String[] args) {
        JFrame previousFrame = new JFrame(); // Dummy frame for testing
        String[] medicineDetails = {"Paracetamol", "Acetaminophen", "Pain relief", "Nausea", "https://example.com/image1.jpg","01/01/2025", "555", "2121"};
        MedicineDetailsWindow frame = new MedicineDetailsWindow(medicineDetails, previousFrame);
        frame.setVisible(true);
    }
}