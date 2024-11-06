package appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FilterPage extends JFrame {

    private JTextField stateField;
    private JTextField ratingField;
    private JTextField ownershipField;
    private JCheckBox emergencyCheckBox;
    private JTextField typeField;
    private JButton applyButton;

    private FilterCallback callback;
    private List<String[]> hospitalData;

    public FilterPage(List<String[]> hospitalData, FilterCallback callback) {
        this.hospitalData = hospitalData;
        this.callback = callback;

        setTitle("Hospital Filter Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Changed to DISPOSE to avoid closing the main app
        setLayout(new BorderLayout());

        // Create heading panel
        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Filter Page");
        headingLabel.setFont(new Font("Serif", Font.BOLD, 24));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingPanel.add(headingLabel);

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        stateField = new JTextField();
        ratingField = new JTextField();
        ownershipField = new JTextField();
        emergencyCheckBox = new JCheckBox("Emergency");
        typeField = new JTextField();
        applyButton = new JButton("Apply Filters");

        inputPanel.add(new JLabel("State:"));
        inputPanel.add(stateField);
        inputPanel.add(new JLabel("Rating:"));
        inputPanel.add(ratingField);
        inputPanel.add(new JLabel("Ownership:"));
        inputPanel.add(ownershipField);
        inputPanel.add(new JLabel("Emergency:"));
        inputPanel.add(emergencyCheckBox);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeField);
        inputPanel.add(new JLabel()); // Placeholder for empty cell
        inputPanel.add(applyButton);

        // Add components to the frame
        add(headingPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);

        // Set the size of the frame
        setSize(600, 400); // Increased size

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Add action listener for the apply button
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = stateField.getText().trim();
                String rating = ratingField.getText().trim();
                String ownership = ownershipField.getText().trim();
                boolean emergency = emergencyCheckBox.isSelected();
                String type = typeField.getText().trim();

                List<String[]> filteredData = filterHospitalData(hospitalData, state, rating, ownership, emergency, type);
                callback.applyFilters(filteredData);
                dispose(); // Close the filter window after applying filters
            }
        });

        setVisible(true);
    }

    private List<String[]> filterHospitalData(List<String[]> hospitalData, String stateFilter, String ratingFilter,
                                              String ownershipFilter, boolean emergencyFilter, String typeFilter) {
        List<String[]> filteredData = new ArrayList<>();

        for (String[] hospital : hospitalData) {
            String hospitalState = hospital[4].trim();
            String hospitalRating = hospital[11].trim();
            String hospitalOwnership = hospital[9].trim();
            String hospitalEmergency = hospital[10].trim().equalsIgnoreCase("TRUE") ? "TRUE" : "FALSE";
            String hospitalType = hospital[8].trim();

            boolean matches = true;
            if (!stateFilter.isEmpty() && !hospitalState.equalsIgnoreCase(stateFilter)) {
                matches = false;
            }
            if (!ratingFilter.isEmpty() && !hospitalRating.equals(ratingFilter)) {
                matches = false;
            }
            if (!ownershipFilter.isEmpty() && !hospitalOwnership.equalsIgnoreCase(ownershipFilter)) {
                matches = false;
            }
            if (emergencyFilter && !hospitalEmergency.equalsIgnoreCase("TRUE")) {
                matches = false;
            }
            if (!typeFilter.isEmpty() && !hospitalType.equalsIgnoreCase(typeFilter)) {
                matches = false;
            }

            if (matches) {
                filteredData.add(hospital);
            }
        }

        return filteredData;
    }

    public interface FilterCallback {
        void applyFilters(List<String[]> filteredData);
    }
}








