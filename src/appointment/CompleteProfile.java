package appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CompleteProfile extends JFrame {

    public CompleteProfile() {
        // Create frame
        setTitle("Complete Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // Create a header panel for the blue border
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.BLUE);
        headerPanel.setPreferredSize(new Dimension(getWidth(), 20));  // Adjust thickness here
        add(headerPanel, BorderLayout.NORTH);

        // Create a main panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add profile picture and email
        JLabel profilePic = new JLabel(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.30.55_81aa128c.jpg"));
        JLabel emailLabel = new JLabel("alexarawles@gmail.com");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(profilePic, gbc);

        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        gbc.gridwidth = 1;

        // Add "Complete Profile" label
        JLabel completeProfileLabel = new JLabel("Complete Profile", SwingConstants.CENTER);
        completeProfileLabel.setFont(new Font("Serif", Font.BOLD, 24));

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(completeProfileLabel, gbc);

        // Add "Reset" button
        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.BLUE);
        resetButton.setForeground(Color.WHITE);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(resetButton, gbc);

        // Add input fields
        String[] labels = {"Full Name", "Gender", "Age", "Mobile no.", "Address", "Nationality", "Do you have any known disability?", "Write your problem"};
        JTextField[] textFields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = (i % 2 == 0) ? 0 : 2;
            gbc.gridy = 2 + i / 2;
            gbc.gridwidth = 1;

            JLabel label = new JLabel(labels[i]);
            panel.add(label, gbc);

            textFields[i] = new JTextField(10);
            gbc.gridx++;
            panel.add(textFields[i], gbc);
        }

        // Add "Save" button
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(Color.BLUE);
        saveButton.setForeground(Color.WHITE);

        gbc.gridx = 2;
        gbc.gridy = labels.length / 2 + 2;
        gbc.gridwidth = 1;
        panel.add(saveButton, gbc);

        // Add validation to age and mobile number fields
        textFields[2].setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                try {
                    int age = Integer.parseInt(textField.getText());
                    return age > 0 && age < 120;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(CompleteProfile.this, "Please enter a valid age (1-120).", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        });

        textFields[3].setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                if (!textField.getText().matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(CompleteProfile.this, "Please enter a valid 10-digit mobile number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });

        // Reset button action listener
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JTextField textField : textFields) {
                    textField.setText("");
                }
            }
        });

        // Save button action listener
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean allFieldsFilled = true;
                for (int i = 0; i < textFields.length; i++) {
                    if (textFields[i].getText().trim().isEmpty()) {
                        allFieldsFilled = false;
                        JOptionPane.showMessageDialog(CompleteProfile.this, "Please fill out all fields: " + labels[i], "Missing Information", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }

                if (allFieldsFilled) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/profile.txt"))) {
                        for (int i = 0; i < labels.length; i++) {
                            writer.write(labels[i] + ": " + textFields[i].getText());
                            writer.newLine();
                        }
                        JOptionPane.showMessageDialog(CompleteProfile.this, "Profile saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new HomePage();  // Redirect to HomePage
                        dispose();      // Close CompleteProfile
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(CompleteProfile.this, "Error saving profile.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CompleteProfile::new);
    }
}



