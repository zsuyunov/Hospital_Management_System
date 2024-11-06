package MyPack;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;











public class NextofKininfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PatientID;
	private JPanel firstName;
	private JLabel lblNewLabel_1;
	private JPanel surname;
	private JLabel lblNewLabel_2;
	private JPanel dateofbirth;
	private JLabel lblNewLabel_3;
	private JPanel telephonenum;
	private JLabel lblNewLabel_4;
	private JPanel email;
	private JLabel lblNewLabel_5;
	private JPanel housenum;
	private JLabel lblNewLabel_6;
	private JPanel streetname;
	private JLabel lblNewLabel_7;
	private JPanel city;
	private JLabel lblNewLabel_9;
	private JPanel postalcode;
	private JLabel lblNewLabel_10;
	private JPanel patientid;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton;
	private JLabel lblNewLabel_12;
	
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
					NextofKininfo frame = new NextofKininfo();
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
	public NextofKininfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FTextField PatientID = new FTextField();
		PatientID.setLineColor(new Color(0, 0, 255));
		PatientID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PatientID.setText("");
		PatientID.setBounds(394, 154, 297, 36);
		contentPane.add(PatientID);
		PatientID.setColumns(10);
		
		PatientID.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (PatientID.getText().equals("")) {
					PatientID.setText("");
					PatientID.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (PatientID.getText().isEmpty()) {
					
				}
			}
		});
		
		PatientID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(PatientID, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

		
		
		
		
		
		FTextField FirstName = new FTextField();
		FirstName.setLineColor(new Color(0, 0, 255));
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstName.setText("");
		FirstName.setBounds(45, 154, 297, 36);
		contentPane.add(FirstName);
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
					
				}
			}
		});
		
		FirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(FirstName, "Please enter only Letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		FTextField Surname = new FTextField();
		Surname.setLineColor(new Color(0, 0, 255));
		Surname.setText("");
		Surname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Surname.setBounds(45, 227, 297, 36);
		contentPane.add(Surname);
		Surname.setColumns(10);
		
		
		Surname.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Surname.getText().equals("Surname")) {
					Surname.setText("");
					Surname.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Surname.getText().isEmpty()) {
					
				}
			}
		});
		
		Surname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume();
					JOptionPane.showMessageDialog(Surname, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		FTextField DateOfBirth = new FTextField();
		DateOfBirth.setLineColor(new Color(0, 0, 255));
		DateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DateOfBirth.setText("");
		DateOfBirth.setBounds(45, 301, 297, 37);
		
		contentPane.add(DateOfBirth);
		DateOfBirth.setColumns(10);
		
		
		DateOfBirth.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (DateOfBirth.getText().equals("Date of Birth")) {
					DateOfBirth.setText("");
					DateOfBirth.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (DateOfBirth.getText().isEmpty()) {
					
				}else {
					SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
					format.setLenient(false);
					try {
						format.parse(DateOfBirth.getText());
					}catch(ParseException PE) {
						JOptionPane.showMessageDialog(null, "Please enter the date in dd/mm/yyyy format.","Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		
		FTextField TelephoneNumber = new FTextField();
		TelephoneNumber.setLineColor(new Color(0, 0, 255));
		TelephoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TelephoneNumber.setText("");
		TelephoneNumber.setBounds(45, 374, 297, 37);
		contentPane.add(TelephoneNumber);
		TelephoneNumber.setColumns(10);
		
		TelephoneNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (TelephoneNumber.getText().equals("Telephone number")) {
					TelephoneNumber.setText("");
					TelephoneNumber.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (TelephoneNumber.getText().isEmpty()) {
					
				}
			}
		});
		
		TelephoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(TelephoneNumber, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField Email = new FTextField();
		Email.setLineColor(new Color(0, 0, 255));
		Email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email.setText("");
		Email.setBounds(45, 450, 297, 36);
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
					
				}
			}
		});
		
		Email.setInputVerifier(new InputVerifier() {
			public boolean verify(JComponent input) {
				String text = ((JTextField) input).getText();
				if (text.isEmpty() || text.equals("Email")) {
					return true;
				}
				String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				if (text.matches(emailPattern)) {
					return true; 
				} else {
					JOptionPane.showMessageDialog(input, "Please enter a valid email address.", "Invalid Email",
							JOptionPane.ERROR_MESSAGE);
					return false; 
				}
			}
		});
		
		
		
		FTextField HouseNumber = new FTextField();
		HouseNumber.setLineColor(new Color(0, 0, 255));
		HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		HouseNumber.setText("");
		HouseNumber.setBounds(394, 227, 297, 36);
		contentPane.add(HouseNumber);
		HouseNumber.setColumns(10);
		
		
		HouseNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (HouseNumber.getText().equals("House number")) {
					HouseNumber.setText("");
					HouseNumber.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (HouseNumber.getText().isEmpty()) {
					
				}
			}
		});
		
		HouseNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(HouseNumber, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField StreetName = new FTextField();
		StreetName.setLineColor(new Color(0, 0, 255));
		StreetName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StreetName.setText("");
		StreetName.setBounds(394, 301, 297, 37);
		contentPane.add(StreetName);
		StreetName.setColumns(10);
		
		
		StreetName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (StreetName.getText().equals("Street name")) {
					StreetName.setText("");
					StreetName.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (StreetName.getText().isEmpty()) {
					
				}
			}
		});
		

		StreetName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(StreetName, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		FTextField City = new FTextField();
		City.setLineColor(new Color(0, 0, 255));
		City.setFont(new Font("Tahoma", Font.PLAIN, 16));
		City.setText("");
		City.setBounds(394, 374, 297, 37);
		contentPane.add(City);
		City.setColumns(10);
		
		
		City.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (City.getText().equals("Town")) {
					City.setText("");
					City.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (City.getText().isEmpty()) {
					
				}
			}
		});
		
		City.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(City, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		FTextField PostalCode = new FTextField();
		PostalCode.setLineColor(new Color(0, 0, 255));
		PostalCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PostalCode.setText("");
		PostalCode.setBounds(394, 450, 297, 36);
		contentPane.add(PostalCode);
		PostalCode.setColumns(10);
		
		PostalCode.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (PostalCode.getText().equals("Postal code")) {
					PostalCode.setText("");
					PostalCode.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (PostalCode.getText().isEmpty()) {
					
				}
			}
		});
		
		PostalCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isLetterOrDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); 
					JOptionPane.showMessageDialog(PostalCode, "Please enter only letter or digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		RoundedButton btnConfirm = new RoundedButton("Confirm", 25);
		btnConfirm.setBackground(new Color(247, 206, 128));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirm.setBounds(313, 495, 113, 28);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
         String email = Email.getText();
				
				if(FirstName.getText().isEmpty() || FirstName.getText().equals("First name")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your First Name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (Surname.getText().isEmpty() || Surname.getText().equals("Surname")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Surname.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (PatientID.getText().isEmpty() || PatientID.getText().equals("PatientID")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your PatientID.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (!PatientID.getText().matches("\\d{8}")) {
					JOptionPane.showMessageDialog(null, "Error: Patient ID must be 8 - digit numbers.", "Error", JOptionPane.ERROR_MESSAGE);
					PatientID.setText("");
				}else if (DateOfBirth.getText().isEmpty() || DateOfBirth.getText().equals("Date of Birth")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Date of Birth.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( TelephoneNumber.getText().isEmpty() || TelephoneNumber.getText().equals("Telephone number")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Telephone number.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (Email.getText().isEmpty() || Email.getText().equals("Email")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Email.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (!(email.contains("@gmail.com") || email.contains("@yahoo.com")
						|| email.contains("@outlook"))) {
					JOptionPane.showMessageDialog(btnConfirm,
							"Please enter an email address from Gmail, Yahoo, or Outlook.", "Invalid Email",
							JOptionPane.ERROR_MESSAGE);	
				}else if (HouseNumber.getText().isEmpty() || HouseNumber.getText().equals("House number")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your House number.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);	
				}else if (StreetName.getText().isEmpty() || StreetName.getText().equals("Street name")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Street name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( City.getText().isEmpty() || City.getText().equals("City")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your City name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( PostalCode.getText().isEmpty() || PostalCode.getText().equals("Postal code")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Postal code.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
					
						} else {
							String INSERT = "INSERT INTO second (PatientID, Firstname, Surname, Dateofbirth, Telephonenumber, Email, Housenumber, Streetname, City, Postalcode) Values (?,?,?,?,?,?,?,?,?,?)";
							
							try (Connection connect = KinDatabase.databaseConn(); PreparedStatement prepare = connect.prepareStatement(INSERT)) 
							{
								prepare.setString(1, FirstName.getText());
								prepare.setString(2, Surname.getText());
								prepare.setString(3, PatientID.getText());
								prepare.setString(4, DateOfBirth.getText());
								prepare.setString(5, TelephoneNumber.getText());
								prepare.setString(6, Email.getText());
								prepare.setString(7, HouseNumber.getText());
								prepare.setString(8, StreetName.getText());
								prepare.setString(9, City.getText());
								prepare.setString(10, PostalCode.getText());
								prepare.executeUpdate();
								
								int option = JOptionPane.showConfirmDialog(null, "<Data saved successfully>." + " Press OK to go to the HOME PAGE", "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
							if(option == JOptionPane.OK_OPTION)
							{
								HomePage enter = new HomePage();
								setVisible(false);
								enter.setVisible(true);
							}
							
							}catch(SQLException e1)
							{
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "Error saving data" + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								
							}
						  }
						}
						
			
		});
		
		
		JLabel lblNewLabel = new JLabel("As a next of kin, please input all the required information");
		lblNewLabel.setForeground(new Color(0, 66, 66));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(183, 63, 450, 22);
		contentPane.add(lblNewLabel);
		
		firstName = new JPanel(null);
		firstName.setBackground(new Color(119, 215, 221));
		firstName.setBounds(102, 127, 182, 28);
		contentPane.add(firstName);
		
		lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 162, 28);
		firstName.add(lblNewLabel_1);
		
		surname = new JPanel(null);
		surname.setBackground(new Color(119, 215, 221));
		surname.setBounds(100, 200, 184, 28);
		contentPane.add(surname);
		
		lblNewLabel_2 = new JLabel("Surname");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 0, 164, 28);
		surname.add(lblNewLabel_2);
		
		dateofbirth = new JPanel(null);
		dateofbirth.setBackground(new Color(119, 215, 221));
		dateofbirth.setBounds(100, 273, 184, 28);
		contentPane.add(dateofbirth);
		
		lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 0, 164, 28);
		dateofbirth.add(lblNewLabel_3);
		
		telephonenum = new JPanel(null);
		telephonenum.setBackground(new Color(119, 215, 221));
		telephonenum.setBounds(100, 348, 184, 28);
		contentPane.add(telephonenum);
		
		lblNewLabel_4 = new JLabel("Telephone number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 0, 164, 28);
		telephonenum.add(lblNewLabel_4);
		
		email = new JPanel(null);
		email.setBackground(new Color(119, 215, 221));
		email.setBounds(102, 424, 182, 28);
		contentPane.add(email);
		
		lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 0, 162, 28);
		email.add(lblNewLabel_5);
		
		housenum = new JPanel(null);
		housenum.setBackground(new Color(119, 215, 221));
		housenum.setBounds(449, 200, 184, 28);
		contentPane.add(housenum);
		
		lblNewLabel_6 = new JLabel("House number");
		lblNewLabel_6.setBounds(10, 0, 164, 28);
		housenum.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		streetname = new JPanel(null);
		streetname.setBackground(new Color(119, 215, 221));
		streetname.setBounds(449, 273, 184, 28);
		contentPane.add(streetname);
		
		lblNewLabel_7 = new JLabel("Street name");
		lblNewLabel_7.setBounds(10, 0, 164, 28);
		streetname.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		city = new JPanel(null);
		city.setBackground(new Color(119, 215, 221));
		city.setBounds(449, 348, 184, 28);
		contentPane.add(city);
		
		lblNewLabel_9 = new JLabel("City");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(10, 0, 164, 28);
		city.add(lblNewLabel_9);
		
		postalcode = new JPanel(null);
		postalcode.setBackground(new Color(119, 215, 221));
		postalcode.setBounds(449, 424, 184, 28);
		contentPane.add(postalcode);
		
		lblNewLabel_10 = new JLabel("Postal code");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 0, 164, 28);
		postalcode.add(lblNewLabel_10);
		
		patientid = new JPanel(null);
		patientid.setBackground(new Color(119, 215, 221));
		patientid.setBounds(449, 127, 182, 28);
		contentPane.add(patientid);
		
		lblNewLabel_11 = new JLabel("Patient ID");
		lblNewLabel_11.setBounds(10, 0, 162, 28);
		patientid.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(673, 20, 37, 22);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage enter = new HomePage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
        
		
		lblNewLabel_12 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Bell.png")).getImage();
		lblNewLabel_12.setIcon(new ImageIcon(img));
		lblNewLabel_12.setBounds(136, 43, 37, 53);
		contentPane.add(lblNewLabel_12);
		
		
		
		
		
		
	}
}
