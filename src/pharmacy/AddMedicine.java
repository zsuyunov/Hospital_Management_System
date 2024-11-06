package pharmacy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddMedicine extends JFrame {

    private static final String CSV_FILE_PATH = "src/medicine-details.csv"; // Update with your CSV file path

    private JTextField nameField;
    private JTextField compositionField;
    private JTextField usesField;
    private JTextField sideeffectsField;
    private JTextField imageurlField;
    private JTextField expiryField;
    private JTextField priceField;
    private JTextField stockField;

    public AddMedicine() {
        // Create the frame
        setTitle("Add Medicine");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1280, 720);

        // Create the panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Medicine Name:");
        nameLabel.setBounds(175, 155, 115, 19);
        nameField = new JTextField();
        nameField.setBounds(332, 143, 247, 43);

        JLabel compositionLabel = new JLabel("Composition:");
        compositionLabel.setBounds(629, 158, 85, 13);
        compositionField = new JTextField();
        compositionField.setBounds(764, 144, 422, 41);

        JLabel usesLabel = new JLabel("Uses:");
        usesLabel.setBounds(629, 306, 58, 13);
        usesField = new JTextField();
        usesField.setBounds(764, 292, 422, 41);

        JLabel sideeffectsLabel = new JLabel("Side effects:");
        sideeffectsLabel.setBounds(632, 227, 82, 13);
        sideeffectsField = new JTextField();
        sideeffectsField.setBounds(764, 216, 422, 36);

        JLabel imageurlLabel = new JLabel("Image URL:");
        imageurlLabel.setBounds(629, 392, 85, 13);
        imageurlField = new JTextField();
        imageurlField.setBounds(764, 381, 422, 36);

        JLabel expiryLabel = new JLabel("Expiry Date:");
        expiryLabel.setBounds(175, 241, 77, 13);
        expiryField = new JTextField();
        expiryField.setBounds(332, 227, 247, 41);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(175, 327, 77, 13);
        priceField = new JTextField();
        priceField.setBounds(332, 312, 77, 43);

        JLabel stockLabel = new JLabel("Stock:");
        stockLabel.setBounds(175, 401, 58, 13);
        stockField = new JTextField();
        stockField.setBounds(332, 392, 77, 36);

        // Add components to panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(compositionLabel);
        panel.add(compositionField);
        panel.add(usesLabel);
        panel.add(usesField);
        panel.add(sideeffectsLabel);
        panel.add(sideeffectsField);
        panel.add(imageurlLabel);
        panel.add(imageurlField);
        panel.add(expiryLabel);
        panel.add(expiryField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(stockLabel);
        panel.add(stockField);

        // Create buttons
        JButton saveButton = new JButton("Save Details");
        saveButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        saveButton.setBackground(new Color(0, 255, 0));
        saveButton.setBounds(520, 632, 115, 41);
        JButton deleteButton = new JButton("Delete Details");
        deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        deleteButton.setBackground(new Color(0, 255, 0));
        deleteButton.setBounds(786, 632, 115, 41);

        // Add action listeners to buttons
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveDetails(
                            nameField.getText(),
                            compositionField.getText(),
                            usesField.getText(),
                            sideeffectsField.getText(),
                            imageurlField.getText(),
                            expiryField.getText(),
                            priceField.getText(),
                            stockField.getText()
                    );
                    JOptionPane.showMessageDialog(AddMedicine.this, "Details Saved");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(AddMedicine.this, "Error saving details: " + ex.getMessage());
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteDetails(nameField.getText());
                    JOptionPane.showMessageDialog(AddMedicine.this, "Details Deleted");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(AddMedicine.this, "Error deleting details: " + ex.getMessage());
                }
            }
        });

        // Add buttons to panel
        panel.add(saveButton);
        panel.add(deleteButton);

        // Add panel to frame
        getContentPane().add(panel);

        JButton btnNewButton_5 = new JButton("LOGOUT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginScreen enter = new LoginScreen();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton_5.setBackground(Color.RED);
        btnNewButton_5.setBounds(1137, 17, 104, 21);
        panel.add(btnNewButton_5);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture2.png"));
        lblNewLabel.setBounds(10, 21, 51, 61);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture3.png"));
        lblNewLabel_1.setBounds(73, 48, 160, 61);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicineList enter = new MedicineList();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(305, 634, 104, 36);
        panel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("DASHBOARD");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DashboardFrame enter = new DashboardFrame();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton_1.setBackground(Color.GREEN);
        btnNewButton_1.setBounds(10, 154, 137, 21);
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("SALES ");
        btnNewButton_2.setBackground(Color.GREEN);
        btnNewButton_2.setBounds(10, 234, 137, 21);
        panel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("NOTIFICATIONS");
        btnNewButton_3.setBackground(Color.GREEN);
        btnNewButton_3.setBounds(10, 314, 137, 21);
        panel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("APPLICATION SETTINGS");
        btnNewButton_4.setBackground(Color.GREEN);
        btnNewButton_4.setBounds(10, 397, 137, 21);
        panel.add(btnNewButton_4);
    }

    private void saveDetails(String name, String composition, String uses, String sideEffects, String imageurl, String expiry, String price, String stock) throws IOException {
        List<String[]> allData = readCSV(CSV_FILE_PATH);

        // Add new data
        String[] newData = {name, composition, uses, sideEffects, imageurl, expiry, price, stock};
        allData.add(newData);

        // Write all data back to the file
        writeCSV(CSV_FILE_PATH, allData);
    }

    private void deleteDetails(String name) throws IOException {
        List<String[]> allData = readCSV(CSV_FILE_PATH);

        // Remove the data with the given name
        boolean removed = allData.removeIf(row -> row[0].equals(name));

        if (!removed) {
            throw new IOException("Name not found in the file");
        }

        // Write all data back to the file
        writeCSV(CSV_FILE_PATH, allData);
    }

    private List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
        }
        return data;
    }

    private void writeCSV(String filePath, List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }

    // Entry point for testing the AddMedicine class independently
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddMedicine frame = new AddMedicine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
