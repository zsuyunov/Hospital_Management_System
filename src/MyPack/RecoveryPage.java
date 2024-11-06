package MyPack;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;

import java.awt.Font;




public class RecoveryPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel MainPanel;
	private JTextField TemporaryPassword;
	private JTextField NewPassword;
	private JTextField Email;
	private JLabel Recovery;
	private JLabel EmailIcon;
	private JLabel LockIcon;
	private JLabel TPIcon;
	private JLabel EmailBorder;
	private JLabel TempPasswordBorder;
	private JLabel NewPasswordBorder;
	private JLabel ReturnBack;
	private JLabel lmageBack;
	private JLabel CheckEmailIcon;

	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private JButton btnNewButton;
	
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
					RecoveryPage frame = new RecoveryPage();
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
	public RecoveryPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel RecoveryPage = new JLabel("Recovery Page");
		RecoveryPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RecoveryPage.setBounds(284, 64, 135, 47);
		contentPane.add(RecoveryPage);
		
		
		//Email input section
		
		FTextField Email = new FTextField();
		Email.setLineColor(new Color(0, 0, 255));
		Email.setBackground(new Color(245, 233, 233));
		Email.setText("Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setBounds(184, 212, 357, 44);
		contentPane.add(Email);
		Email.setColumns(10);

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
		Email.setMargin(new Insets(0, 0, 0, 0));
		Email.setForeground(new Color(0, 0, 0, 80));
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
		
		//Temporary Password section
		
		FTextField TemporaryPassword = new FTextField();
		TemporaryPassword.setLineColor(new Color(0, 0, 255));
		TemporaryPassword.setBackground(new Color(245, 233, 233));
		TemporaryPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TemporaryPassword.setText("Temporary Password");
		TemporaryPassword.setBounds(184, 266, 357, 44);
		contentPane.add(TemporaryPassword);
		TemporaryPassword.setColumns(10);
		TemporaryPassword.setMargin(new Insets(0, 0, 0, 0));
		TemporaryPassword.setForeground(new Color(0, 0, 0, 80));
		
		TemporaryPassword.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (TemporaryPassword.getText().equals("Temporary Password")) {
					TemporaryPassword.setText("");
					TemporaryPassword.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (TemporaryPassword.getText().isEmpty()) {
					TemporaryPassword.setText("Temporary Password");
					TemporaryPassword.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		//New Password section
		
		FTextField NewPassword = new FTextField();
		NewPassword.setLineColor(new Color(0, 0, 255));
		NewPassword.setBackground(new Color(245, 233, 233));
		NewPassword.setBounds(184, 320, 357, 44);
		contentPane.add(NewPassword);
		NewPassword.setForeground(new Color(0, 0, 0, 80));
		NewPassword.setMargin(new Insets(0, 0, 0, 0));
		NewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NewPassword.setColumns(10);
		NewPassword.setText("New Password");
		NewPassword.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (NewPassword.getText().equals("New Password")) {
					NewPassword.setText("");
					NewPassword.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (NewPassword.getText().isEmpty()) {
					NewPassword.setText("New Password");
					NewPassword.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		
		    //Rounded JButton for email
		
		    RoundedButton btnMail = new RoundedButton("Mail", 20);
			btnMail.setBackground(new Color(119, 215, 221));
			btnMail.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnMail.setBounds(551, 219, 65, 32);
			contentPane.add(btnMail);
			btnMail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String query = ("SELECT * FROM users WHERE email = ?");
					try (Connection connect = LogDatabase.connectionDB(); PreparedStatement prepare = connect.prepareStatement(query);)
					{ prepare.setString(1, Email.getText());
                      ResultSet result = prepare.executeQuery();

                      //Preparation of temporary password
					if (result.next()) {	
						String tempPassword = PasswordGenerator.generatePassword(16);
						String recipientEmail = Email.getText(); 
						String subject = "Your Temporary Password";
						String emailBody = "Dear User,\n\nWe've created a temporary password for your account, as you requested. You can find it below. For your security, we highly recommend that you change this password as soon as you log in..\n\nTemporary Password: "
								+ tempPassword
								+ "\n\nIf you have any questions or need further assistance, please do not hesitate to contact our support team.\n\nBest Regards,\n Patient information Support Team";

						//Email sent result
						EmailSent.sendEmail(recipientEmail, subject, emailBody);
						JOptionPane.showMessageDialog(null, "A temporary password has been sent to your email.",
								"Success", JOptionPane.INFORMATION_MESSAGE);
					 } else {
						JOptionPane.showMessageDialog(null, "Email address not found.", "Error",
								JOptionPane.ERROR_MESSAGE);
					 }
				    } catch (SQLException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "An error occurred while accessing the database.", "Error",
							JOptionPane.ERROR_MESSAGE);
				    } catch (MessagingException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed to send temporary password email.", "Email Error",
							JOptionPane.ERROR_MESSAGE);
				}
				}
			});
			
					
	
	


		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(677, 33, 36, 24);
		contentPane.add(btnNewButton);
		
		 btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginPage enter = new LoginPage();
					setVisible(false);
					enter.setVisible(true);
			

				}
			});
	        
		

	

	


		
		
		RoundedButton Submit = new RoundedButton("Submit", 25);
		Submit.setFont(new Font("Tahoma", Font.BOLD, 18));
		Submit.setBounds(284, 407, 135, 32);
		contentPane.add(Submit);
		
		
		//Submit.setForeground(new Color(13, 146, 118));
		Submit.setBackground(new Color(247, 206, 128));
		
		JLabel lblNewLabel = new JLabel("If you forgot your password, input your email you signed up and click \"Mail\" button.");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(138, 136, 469, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The system will send you \"Temporary Password\" to enter your account");
		lblNewLabel_1.setBackground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(163, 159, 431, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("By entering \"New Password\" you can update your password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(199, 182, 383, 19);
		contentPane.add(lblNewLabel_2);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userEmail = Email.getText().trim(); 
				String tempPassword = TemporaryPassword.getText().trim(); 
				String newPassword = NewPassword.getText().trim(); 
																	

				if (!userEmail.equals("Email") && !userEmail.isEmpty() && !newPassword.equals("New Password")
						&& !newPassword.isEmpty() && tempPassword.length() == 16) {
					String updateSQL = ("UPDATE users SET password = ? WHERE email = ?");

					try (Connection connect = LogDatabase.connectionDB();
							PreparedStatement prepare = connect.prepareStatement(updateSQL)) {

						prepare.setString(1, newPassword);
						prepare.setString(2, userEmail);

						int affectedRows = prepare.executeUpdate();

						if (affectedRows > 0) {
							System.out.println("Password update successful");
							
							LoginPage enter = new LoginPage();
							dispose(); 
							enter.setVisible(true);
						} else {
							System.out.println("Password update failed");
							JOptionPane.showMessageDialog(null, "Password update failed.", "Update Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					
					JOptionPane.showMessageDialog(null,
							"Please fill in all fields correctly and ensure the temporary password is valid.",
							"Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
	    	}
		 }
	
	

	

