package pharmacy;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
    	getContentPane().setBackground(new Color(0, 255, 255));
        setTitle("Axis Pharma");
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(828, 370, 80, 25);
        getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if (usernameField.getText().equals("Username"))  {
        			usernameField.setText("");	
        			usernameField.setForeground(Color.BLACK);
        		}
        	}
        });
        
        usernameField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		if (usernameField.getText().isEmpty()) {
        			usernameField.setText("Username");	
        			usernameField.setForeground( new Color(0,0,0,60));
        		}
        	}
        });
        usernameField.setBackground(new Color(255, 255, 255));
        usernameField.setBounds(772, 370, 160, 25);
        getContentPane().add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(828, 450, 80, 25);
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(772, 450, 160, 25);
        getContentPane().add(passwordField);
        
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		if (passwordField.getText().equals("Username"))  {
        			passwordField.setText("");	
        			passwordField.setForeground(Color.BLACK);
        		}
        	}
        });
        
        passwordField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		if (passwordField.getText().isEmpty()) {
        			passwordField.setText("Username");	
        			passwordField.setForeground( new Color(0,0,0,60));
        		}
        	}
        });

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 10));
        loginButton.setToolTipText("");
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 255, 64));
        loginButton.setBounds(794, 515, 100, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DashboardFrame enter = new DashboardFrame();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        getContentPane().add(loginButton);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(59, 192, 29, 0);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture1.png"));
        lblNewLabel_1.setBounds(41, 72, 411, 507);
        getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture5.png"));
        lblNewLabel_2.setBounds(651, 159, 352, 170);
        getContentPane().add(lblNewLabel_2);
        
        JTextArea txtrUsernameNeelesh = new JTextArea();
        txtrUsernameNeelesh.setBackground(new Color(0, 255, 255));
        txtrUsernameNeelesh.setText("UserName: Neelesh");
        txtrUsernameNeelesh.setBounds(981, 370, 160, 22);
        getContentPane().add(txtrUsernameNeelesh);
        
        JTextArea txtrPassword = new JTextArea();
        txtrPassword.setBackground(new Color(0, 255, 255));
        txtrPassword.setText("Password: 123456");
        txtrPassword.setBounds(981, 450, 160, 22);
        getContentPane().add(txtrPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LoginScreen frame = new LoginScreen();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
