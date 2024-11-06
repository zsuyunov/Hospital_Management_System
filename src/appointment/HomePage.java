package appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends JFrame implements FilterPage.FilterCallback {

    private List<String[]> hospitalData;
    private static final String IMAGE_PATH = "C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.31.40_36d35f1e.jpg";
    private static final String MY_BOOKINGS_IMAGE_PATH = "C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.30.55_356a5cd9.jpg";
    private static final String HOME_ICON_PATH = "C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.30.55_d11959f4.jpg";
    private JPanel hospitalPanel;

    public HomePage() {
        String filePath = "src/hospital-info.csv";  // Update with your file path

        loadCSVData(filePath);

        setTitle("Hospital Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout());
        searchPanel.setBackground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel homeIconLabel = new JLabel();
        ImageIcon homeIcon = new ImageIcon(HOME_ICON_PATH);
        Image homeImage = homeIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        homeIconLabel.setIcon(new ImageIcon(homeImage));

        JLabel headingLabel = new JLabel("Home");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));

        topPanel.add(homeIconLabel);
        topPanel.add(headingLabel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton filterButton = new JButton("Filter");
        JLabel myBookingsLabel = new JLabel();
        ImageIcon myBookingsIcon = new ImageIcon(MY_BOOKINGS_IMAGE_PATH);
        Image myBookingsImage = myBookingsIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        myBookingsLabel.setIcon(new ImageIcon(myBookingsImage));

        searchButton.setBackground(Color.BLUE);
        searchButton.setForeground(Color.WHITE);
        filterButton.setBackground(Color.BLUE);
        filterButton.setForeground(Color.WHITE);

        bottomPanel.add(new JLabel("Enter Hospital Name:"));
        bottomPanel.add(searchField);
        bottomPanel.add(searchButton);
        bottomPanel.add(filterButton);
        bottomPanel.add(myBookingsLabel);

        searchPanel.add(topPanel, BorderLayout.NORTH);
        searchPanel.add(bottomPanel, BorderLayout.CENTER);

        hospitalPanel = new JPanel();
        hospitalPanel.setBackground(Color.WHITE);
        hospitalPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns, 10px gaps

        JScrollPane scrollPane = new JScrollPane(hospitalPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setBackground(Color.WHITE);

        // Display initial hospital details
        displayInitialHospitals(hospitalPanel);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hospitalName = searchField.getText();
                List<String[]> result = searchHospital(hospitalName);
                hospitalPanel.removeAll();
                if (result != null && !result.isEmpty()) {
                    for (String[] hospital : result) {
                        hospitalPanel.add(createHospitalCard(hospital));
                    }
                } else {
                    JOptionPane.showMessageDialog(HomePage.this, "Hospital not found");
                    displayInitialHospitals(hospitalPanel);
                }
                hospitalPanel.revalidate();
                hospitalPanel.repaint();
            }
        });

        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FilterPage(hospitalData, HomePage.this); // Pass the current hospital data and callback
            }
        });

        myBookingsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new MyBookings().setVisible(true);
            }
        });

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void loadCSVData(String filePath) {
        hospitalData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                if (line.contains("\"")) {
                    continue;
                }
                String[] values = line.split(",");
                hospitalData.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayInitialHospitals(JPanel hospitalPanel) {
        for (int i = 0; i < 4 && i < hospitalData.size(); i++) {
            hospitalPanel.add(createHospitalCard(hospitalData.get(i)));
        }
    }

    private JPanel createHospitalCard(String[] hospital) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        card.setPreferredSize(new Dimension(350, 300)); // Adjust size as necessary
        card.setBackground(Color.WHITE);

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(IMAGE_PATH);
        Image image = imageIcon.getImage().getScaledInstance(420, 190, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));

        JLabel nameLabel = new JLabel("Name: " + hospital[1]);
        JLabel addressLabel = new JLabel("Address: " + hospital[2]);
        JLabel phoneNumberLabel = new JLabel("Phone Number: " + hospital[7]);
        JLabel hospitalOwnershipLabel = new JLabel("Hospital Ownership: " + hospital[9]);
        JLabel ratingLabel = new JLabel("Rating: " + hospital[11]); // Assuming column 11 is the rating

        JButton bookButton = new JButton("Book");
        bookButton.setBackground(Color.BLUE);
        bookButton.setForeground(Color.WHITE);
        bookButton.addActionListener(e -> new BookAppointment(hospital, IMAGE_PATH).setVisible(true));

        card.add(imageLabel);
        card.add(nameLabel);
        card.add(addressLabel);
        card.add(phoneNumberLabel);
        card.add(hospitalOwnershipLabel);
        card.add(ratingLabel);
        card.add(bookButton);

        return card;
    }

    private List<String[]> searchHospital(String hospitalName) {
        List<String[]> results = new ArrayList<>();
        for (String[] row : hospitalData) {
            if (row[1].equalsIgnoreCase(hospitalName)) {
                results.add(row);
            }
        }
        return results;
    }

    @Override
    public void applyFilters(List<String[]> filteredData) {
        hospitalPanel.removeAll();
        for (String[] hospital : filteredData) {
            hospitalPanel.add(createHospitalCard(hospital));
        }
        hospitalPanel.revalidate();
        hospitalPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HomePage::new);
    }
}









