package Restaurant;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class loginpage {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginpage window = new loginpage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginpage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Username");
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setBounds(43, 30, 287, 27);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setForeground(new Color(0, 128, 128));
        lblNewLabel_1.setBounds(43, 67, 301, 27);
        frame.getContentPane().add(lblNewLabel_1);
        
        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 27);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 67, 200, 27);
        frame.getContentPane().add(passwordField);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(0, 128, 128));
        btnLogin.setBounds(150, 120, 89, 23);
        frame.getContentPane().add(btnLogin);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(50, 200, 100, 30);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                homepage.setVisible(true);
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnBack);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                String correctUsername = "user123";
                String correctPassword = "mypassword";

                if (username.equals(correctUsername) && password.equals(correctPassword)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                Menupage menuPage = new Menupage();
                                menuPage.setVisible(true);
                                frame.dispose();  // close the login page
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
