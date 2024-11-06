package appointment;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ForgotPasswordPage extends JFrame {

    private JTextField emailField;
    private JLabel statusLabel;

    public ForgotPasswordPage() {
        setTitle("Forgot Password");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        JLabel emailLabel = new JLabel("Enter your email:");
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        emailLabel.setBounds(50, 50, 200, 30);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(50, 90, 400, 30);
        add(emailField);

        JButton resetButton = new JButton("Reset Password");
        resetButton.setFont(new Font("Poppins", Font.PLAIN, 20));
        resetButton.setBounds(150, 150, 200, 50);
        resetButton.setBackground(new Color(13, 92, 245));
        resetButton.setForeground(Color.WHITE);
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder());
        resetButton.addActionListener(e -> handlePasswordReset());
        add(resetButton);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        statusLabel.setForeground(Color.RED);
        statusLabel.setBounds(50, 220, 400, 30);
        add(statusLabel);
    }

    private void handlePasswordReset() {
        String email = emailField.getText();

        if (email.isEmpty()) {
            statusLabel.setText("Email field is required.");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("src/users.txt"))) {
                String line;
                boolean found = false;
                while ((line = reader.readLine()) != null) {
                    String[] userDetails = line.split(",");
                    if (userDetails.length == 3 && userDetails[0].equals(email)) {
                        found = true;
                        String newPassword = generateRandomPassword();
                        updatePassword(email, newPassword);
                        JOptionPane.showMessageDialog(this, "Your new password is: " + newPassword);
                        statusLabel.setText("Password reset successful.");
                        statusLabel.setForeground(Color.GREEN);
                        break;
                    }
                }

                if (!found) {
                    statusLabel.setText("Email not found.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateRandomPassword() {
        int length = 8;
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+<>?";

        String allCharacters = upperCaseLetters + lowerCaseLetters + digits + specialCharacters;
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);

        // Ensure the password has at least one of each required type
        sb.append(upperCaseLetters.charAt(rnd.nextInt(upperCaseLetters.length())));
        sb.append(lowerCaseLetters.charAt(rnd.nextInt(lowerCaseLetters.length())));
        sb.append(digits.charAt(rnd.nextInt(digits.length())));
        sb.append(specialCharacters.charAt(rnd.nextInt(specialCharacters.length())));

        // Fill the remaining characters
        for (int i = 4; i < length; i++) {
            sb.append(allCharacters.charAt(rnd.nextInt(allCharacters.length())));
        }

        // Shuffle the characters to avoid predictable sequences
        char[] password = sb.toString().toCharArray();
        for (int i = password.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }

        return new String(password);
    }

    private void updatePassword(String email, String newPassword) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Sathwik Jangili\\eclipse-workspace\\HospitalAppointmentSystem\\users.txt"));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 3 && userDetails[0].equals(email)) {
                    sb.append(email).append(",").append(newPassword).append(",").append(userDetails[2]).append("\n");
                } else {
                    sb.append(line).append("\n");
                }
            }
            reader.close();

            FileWriter writer = new FileWriter("C:\\Users\\Sathwik Jangili\\eclipse-workspace\\HospitalAppointmentSystem\\users.txt");
            writer.write(sb.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ForgotPasswordPage::new);
    }
}



