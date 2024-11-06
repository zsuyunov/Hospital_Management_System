package MyPack;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.border.EmptyBorder;












public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Email;
	private JButton btnNewButton;
	private JTextField txtPassword;
	
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail\\.com|yahoo\\.com|outlook\\.com)$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage frame = new SignUpPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign up for an account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(262, 122, 202, 32);
		contentPane.add(lblNewLabel);

		FTextField FirstName = new FTextField();
		FirstName.setLineColor(new Color(0, 0, 255));
		FirstName.setBackground(new Color(244, 233, 233));
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FirstName.setText("First Name");
		FirstName.setBounds(160, 180, 199, 47);
		contentPane.add(FirstName);
		FirstName.setForeground(new Color(0, 0, 0, 60));
		FirstName.setColumns(10);

		FirstName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (FirstName.getText().equals("First Name")) {
					FirstName.setText("");
					FirstName.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (FirstName.getText().isEmpty()) {
					FirstName.setText("First Name");
					FirstName.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		FirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(FirstName, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});



		FTextField LastName = new FTextField();
		LastName.setLineColor(new Color(0, 0, 255));
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LastName.setText("Last Name");
		LastName.setBounds(382, 180, 199, 47);
		LastName.setForeground(new Color(0, 0, 0, 60));
		contentPane.add(LastName);
		LastName.setColumns(10);
		LastName.setBackground(new Color(244, 233, 233));

		LastName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (LastName.getText().equals("Last Name")) {
					LastName.setText("");
					LastName.setForeground(Color.BLACK);
					
				}

			}

			public void focusLost(FocusEvent e) {
				if (LastName.getText().isEmpty()) {
					LastName.setText("Last Name");
					LastName.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		LastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(LastName, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});





		FTextField Email = new FTextField();
		Email.setLineColor(new Color(0, 0, 255));
		Email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Email.setText("Email");
		Email.setBounds(160, 240, 421, 47);
		Email.setForeground(new Color(0, 0, 0, 60));
		contentPane.add(Email);
		Email.setColumns(10);
		Email.setBackground(new Color(244, 233, 233));

		Email.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Email.getText().equals("Email")) {
					Email.setText("");
					Email.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Email.getText().isEmpty()) {
					Email.setText("Email");
					Email.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		Email.setInputVerifier(new InputVerifier() {
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				if (text.isEmpty() || text.equals("Email")) {
					return true; // Consider empty field as not needing verification here
				}
				String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				if (text.matches(emailPattern)) {
					return true; // Email is valid
				} else {
					JOptionPane.showMessageDialog(input, "Please enter a valid email address.", "Invalid Email",
							JOptionPane.ERROR_MESSAGE);
					return false; // Email is not valid
				}
			}
		});
		
		
		FTextField Password = new FTextField();
		Password.setLineColor(new Color(0, 0, 255));
		Password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Password.setText("Password");
		Password.setBounds(160, 304, 421, 47);
		contentPane.add(Password);
		Password.setForeground(new Color(0, 0, 0, 60));
		Password.setColumns(10);
		
		
		Password.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Password.getText().equals("Password")) {
					Password.setText("");
					Password.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Password.getText().isEmpty()) {
					Password.setText("Password");
					Password.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		


		RoundedButton SignUp = new RoundedButton("Sign up", 25);
		SignUp.setBackground(new Color(247, 206, 128));
		SignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		SignUp.setBounds(262, 408, 202, 38);
		contentPane.add(SignUp);

		SignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = FirstName.getText();
				String lastName = LastName.getText();
				String email = Email.getText();
				String password = Password.getText();

				

				// Check if any of the fields are empty or not correctly filled
				if (firstName.isEmpty() || firstName.equals("First Name")) {
					JOptionPane.showMessageDialog(SignUp, "Please enter your First Name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else if (lastName.isEmpty() || lastName.equals("Last Name")) {
					JOptionPane.showMessageDialog(SignUp, "Please enter your Last Name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else if (!(email.contains("@gmail.com") || email.contains("@yahoo.com")
						|| email.contains("@outlook"))) {
					JOptionPane.showMessageDialog(SignUp,
							"Please enter an email address from Gmail, Yahoo, or Outlook.", "Invalid Email",
							JOptionPane.ERROR_MESSAGE);
				} else if (password.isEmpty()) {
					JOptionPane.showMessageDialog(SignUp, "Password cannot be empty.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else if (password.contains(" ")) {
					JOptionPane.showMessageDialog(SignUp, "Password cannot contain spaces.", "Invalid Password",
							JOptionPane.ERROR_MESSAGE);
				} else if (password.length() < 9 || password.length() > 16) {
					JOptionPane.showMessageDialog(SignUp, "Password must be between 9 to 16 characters.",
							"Invalid Password", JOptionPane.ERROR_MESSAGE);
				} else {
					

					try {
						Connection connect = LogDatabase.connectionDB();

						String register = "INSERT INTO users (First_Name, Last_Name, Email, Password) VALUES (?, ?, ?, ?)";
						PreparedStatement prepare = connect.prepareStatement(register);

						prepare.setString(1, firstName);
						prepare.setString(2, lastName);
						prepare.setString(3, email);
						prepare.setString(4, password);

						int affectedRows = prepare.executeUpdate();
						if (affectedRows > 0) {

							JOptionPane.showMessageDialog(SignUp, "Registration Successful.", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							LoginPage enter = new LoginPage();
							dispose();
							enter.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(SignUp, "Registration Failed.", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(SignUp, "Database error occurred.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});


		JLabel HavaccSignin = new JLabel("Already have an account? Sign in");
		HavaccSignin.setForeground(new Color(0, 106, 106));
		HavaccSignin.setFont(new Font("Tahoma", Font.BOLD, 11));
		HavaccSignin.setBounds(272, 448, 192, 13);
		contentPane.add(HavaccSignin);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(677, 33, 38, 24);
		contentPane.add(btnNewButton);
		
		
		
		 btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginPage enter = new LoginPage();
					setVisible(false);
					enter.setVisible(true);
				}
			});
	        
		

		HavaccSignin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				dispose();
				LoginPage signInPage = new LoginPage();
				signInPage.setVisible(true);
			}
		});
	}
}
			

	




