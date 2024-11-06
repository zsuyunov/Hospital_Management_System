package appointment;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class CreateAccountPage extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField mobileField;
    private JCheckBox showPasswordCheckbox;
    private JLabel invalidDetailsLabel;

    public CreateAccountPage() {
        setTitle("Create Account");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel topBorder = new JPanel();
        topBorder.setBackground(new Color(13, 92, 245));
        topBorder.setBounds(0, 0, 800, 40);
        add(topBorder);

        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        JLabel createAccountLabel = new JLabel("Create Account");
        createAccountLabel.setFont(new Font("Inter", Font.PLAIN, 40));
        createAccountLabel.setBounds(260, 50, 300, 50);
        add(createAccountLabel);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(null);
        emailPanel.setBounds(50, 100, 700, 100);
        emailPanel.setBackground(Color.WHITE);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        emailLabel.setBounds(0, 0, 700, 30);
        emailPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(0, 40, 700, 30);
        emailPanel.add(emailField);

        add(emailPanel);

        JPanel mobilePanel = new JPanel();
        mobilePanel.setLayout(null);
        mobilePanel.setBounds(50, 200, 700, 100);
        mobilePanel.setBackground(Color.WHITE);

        JLabel mobileLabel = new JLabel("Mobile Number");
        mobileLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        mobileLabel.setBounds(0, 0, 700, 30);
        mobilePanel.add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setBounds(0, 40, 700, 30);
        mobilePanel.add(mobileField);

        add(mobilePanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(null);
        passwordPanel.setBounds(50, 300, 700, 120);
        passwordPanel.setBackground(Color.WHITE);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        passwordLabel.setBounds(0, 0, 700, 30);
        passwordPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(0, 40, 700, 30);
        passwordPanel.add(passwordField);

        showPasswordCheckbox = new JCheckBox("Show Password");
        showPasswordCheckbox.setFont(new Font("Inter", Font.PLAIN, 15));
        showPasswordCheckbox.setBackground(Color.WHITE);
        showPasswordCheckbox.setBounds(0, 80, 150, 30);
        showPasswordCheckbox.addActionListener(e -> {
            if (showPasswordCheckbox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('•');
            }
        });
        passwordPanel.add(showPasswordCheckbox);

        add(passwordPanel);

        invalidDetailsLabel = new JLabel("Invalid user details");
        invalidDetailsLabel.setForeground(Color.RED);
        invalidDetailsLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        invalidDetailsLabel.setBounds(50, 440, 700, 20);
        invalidDetailsLabel.setVisible(false);
        add(invalidDetailsLabel);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Poppins", Font.PLAIN, 20));
        signUpButton.setBounds(300, 470, 200, 50);
        signUpButton.setBackground(new Color(13, 92, 245));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder());
        signUpButton.addActionListener(e -> handleSignUp());
        add(signUpButton);
    }

    private void handleSignUp() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String mobile = mobileField.getText();

        String emailPattern = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        String passwordPattern = "^(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";
        String mobilePattern = "^\\d{10}$";

        if (email.isEmpty() || password.isEmpty() || mobile.isEmpty()) {
            invalidDetailsLabel.setText("All fields are required.");
            invalidDetailsLabel.setVisible(true);
        } else if (!Pattern.matches(emailPattern, email)) {
            invalidDetailsLabel.setText("Invalid email format. Must be ....@gmail.com");
            invalidDetailsLabel.setVisible(true);
        } else if (!Pattern.matches(passwordPattern, password)) {
            invalidDetailsLabel.setText("Password must be at least 8 characters and contain one special character.");
            invalidDetailsLabel.setVisible(true);
        } else if (!Pattern.matches(mobilePattern, mobile)) {
            invalidDetailsLabel.setText("Mobile number must be 10 digits.");
            invalidDetailsLabel.setVisible(true);
        } else {
            try (FileWriter file = new FileWriter("src/users.txt", true)) {
                file.write(email + "," + password + "," + mobile + "\n");
                JOptionPane.showMessageDialog(this, "Account Created Successfully!");
                invalidDetailsLabel.setVisible(false);
                new SignInPage();
                dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CreateAccountPage::new);
    }
}


