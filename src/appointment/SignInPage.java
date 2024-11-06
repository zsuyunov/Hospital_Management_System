package appointment;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SignInPage extends JFrame {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckbox;
    private JLabel invalidDetailsLabel;

    public SignInPage() {
        setTitle("Sign In");
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
        JLabel signInLabel = new JLabel("Sign In");
        signInLabel.setFont(new Font("Inter", Font.PLAIN, 40));
        signInLabel.setBounds(320, 50, 200, 50);
        add(signInLabel);

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(null);
        emailPanel.setBounds(50, 120, 700, 100);
        emailPanel.setBackground(Color.WHITE);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        emailLabel.setBounds(0, 0, 700, 30);
        emailPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(0, 40, 700, 30);
        emailPanel.add(emailField);

        invalidDetailsLabel = new JLabel("Invalid user details");
        invalidDetailsLabel.setForeground(Color.RED);
        invalidDetailsLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        invalidDetailsLabel.setBounds(0, 80, 700, 20);
        invalidDetailsLabel.setVisible(false);
        emailPanel.add(invalidDetailsLabel);

        add(emailPanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(null);
        passwordPanel.setBounds(50, 240, 700, 120);
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

        JButton signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Poppins", Font.PLAIN, 20));
        signInButton.setBounds(300, 400, 200, 50);
        signInButton.setBackground(new Color(13, 92, 245));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.setBorder(BorderFactory.createEmptyBorder());
        signInButton.addActionListener(e -> handleSignIn());
        add(signInButton);

        JLabel forgotPasswordLabel = new JLabel("Forgot Password?");
        forgotPasswordLabel.setFont(new Font("Inter", Font.PLAIN, 15));
        forgotPasswordLabel.setForeground(Color.BLUE);
        forgotPasswordLabel.setBounds(350, 460, 150, 30);
        forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new ForgotPasswordPage();
            }
        });
        add(forgotPasswordLabel);
    }

    private void handleSignIn() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            invalidDetailsLabel.setText("All fields are required.");
            invalidDetailsLabel.setVisible(true);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("src/users.txt"))) {
                String line;
                boolean found = false;
                while ((line = reader.readLine()) != null) {
                    String[] userDetails = line.split(",");
                    if (userDetails.length == 3 && userDetails[0].equals(email) && userDetails[1].equals(password)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    JOptionPane.showMessageDialog(this, "Sign In Successful!");
                    invalidDetailsLabel.setVisible(false);
                    new CompleteProfile();  // Redirect to CompleteProfile
                    dispose();              // Close SignInPage
                } else {
                    invalidDetailsLabel.setText("Invalid email or password.");
                    invalidDetailsLabel.setVisible(true);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignInPage::new);
    }
}





 








	
