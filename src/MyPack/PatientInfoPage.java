package MyPack;

import java.awt.Color;







import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.Connection.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;







 
 
 

public class PatientInfoPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField Surname;
	private JTextField DateOfBirth;
	private JTextField TelephoneNumber;
	private JTextField Email;
	private JTextField HouseNumber;
	private JTextField StreetName;
	private JTextField City;
	private JTextField Town;
	private JTextField PostalCode;
	private JComboBox<String> combobox;
	protected CharSequence abc;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JPanel panel;
	private JLabel lblNewLabel_4;
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	private JComboBox comboBoxday;
	private JComboBox comboBoxmonth;
	private JComboBox comboBoxyear;
	
	//private Map<String, String> countryPhoneCodes1 = createCountryPhoneCodes();
    //private Set<Integer> validCountryCodes1 = createValidCountryCodes();
	
	
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
					PatientInfoPage frame = new PatientInfoPage();
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
	public PatientInfoPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.combobox = new JComboBox<String>();
		combobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadProblems();
			}
		});
		combobox.setBounds(257, 348, 434, 34);
		contentPane.add(combobox);
		combobox.setBackground(new Color(236, 236, 255));
		combobox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		combobox.setMaximumRowCount(10);
		combobox.setName("");
		combobox.setForeground(Color.BLUE);
		combobox.setEditable(false);
		
		
		combobox.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(combobox.getSelectedIndex()==0) {
					combobox.setSelectedItem(null);
					combobox.setForeground(Color.BLUE);
				}
			}
			
			public void focusLost(FocusEvent e) {
				if(combobox.getSelectedItem()== null || combobox.getSelectedIndex()== -1) {
					combobox.setSelectedIndex(0);	
					combobox.setForeground(Color.BLUE);
			 }
			}
		});
		loadProblems();
		
		ButtonGroup disabilityGR = new ButtonGroup();
		
		FTextField FirstName = new FTextField();
		FirstName.setLineColor(new Color(0, 0, 255));
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FirstName.setText("First Name");
		FirstName.setBounds(45, 69, 297, 34);
		contentPane.add(FirstName);
		FirstName.setColumns(10);
		FirstName.setForeground(new Color(0, 0, 0, 60));
		
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
					FirstName.setForeground(new Color(0, 0, 0, 60));
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
					JOptionPane.showMessageDialog(FirstName, "Please enter only Letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField Surname = new FTextField();
		Surname.setLineColor(new Color(0, 0, 255));
		Surname.setText("Surname");
		Surname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Surname.setBounds(45, 113, 297, 34);
		contentPane.add(Surname);
		Surname.setColumns(10);
		Surname.setForeground(new Color(0, 0, 0, 60));
		
		Surname.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Surname.getText().equals("Surname")) {
					Surname.setText("");
					Surname.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Surname.getText().isEmpty()) {
					Surname.setText("Surname");
					Surname.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		Surname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(Surname, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField DateOfBirth = new FTextField();
		DateOfBirth.setLineColor(new Color(0, 0, 255));
		DateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DateOfBirth.setText("Date of Birth");
		DateOfBirth.setBounds(45, 157, 297, 34);
		DateOfBirth.setForeground(new Color(0, 0, 0, 60));
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
					DateOfBirth.setText("Date of Birth");
					DateOfBirth.setForeground(new Color(0, 0, 0, 60));
				} else {
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
					format.setLenient(false);
					try {
						format.parse(DateOfBirth.getText());
					}catch(ParseException PE) {
						JOptionPane.showMessageDialog(null, "Please enter the date in MM/dd/yyyy format.","Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}
		});
		
		FTextField TelephoneNumber = new FTextField();
		TelephoneNumber.setLineColor(new Color(0, 0, 255));
		TelephoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TelephoneNumber.setText("Telephone number");
		TelephoneNumber.setBounds(45, 201, 297, 34);
		contentPane.add(TelephoneNumber);
		TelephoneNumber.setColumns(10);
		TelephoneNumber.setForeground(new Color(0, 0, 0, 60));
		
		
		TelephoneNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (TelephoneNumber.getText().equals("Telephone number")) {
					TelephoneNumber.setText("");
					TelephoneNumber.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (TelephoneNumber.getText().isEmpty()) {
					TelephoneNumber.setText("Telephone number");
					TelephoneNumber.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		TelephoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(TelephoneNumber, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField Email = new FTextField();
		Email.setLineColor(new Color(0, 0, 255));
		Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email.setText("Email");
		Email.setBounds(45, 245, 297, 34);
		contentPane.add(Email);
		Email.setColumns(10);
		Email.setForeground(new Color(0, 0, 0, 60));
		
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
					Email.setForeground(new Color(0, 0, 0, 60));
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
		
		
		
		
		FTextField HouseNumber = new FTextField();
		HouseNumber.setLineColor(new Color(0, 0, 255));
		HouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		HouseNumber.setText("House number");
		HouseNumber.setBounds(394, 69, 297, 34);
		contentPane.add(HouseNumber);
		HouseNumber.setColumns(10);
		HouseNumber.setForeground(new Color(0, 0, 0, 60));
		
		HouseNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (HouseNumber.getText().equals("House number")) {
					HouseNumber.setText("");
					HouseNumber.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (HouseNumber.getText().isEmpty()) {
					HouseNumber.setText("House number");
					HouseNumber.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		HouseNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(HouseNumber, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		FTextField StreetName = new FTextField();
		StreetName.setLineColor(new Color(0, 0, 255));
		StreetName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		StreetName.setText("Street name");
		StreetName.setBounds(394, 113, 297, 34);
		contentPane.add(StreetName);
		StreetName.setColumns(10);
		StreetName.setForeground(new Color(0, 0, 0, 60));
		
		StreetName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (StreetName.getText().equals("Street name")) {
					StreetName.setText("");
					StreetName.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (StreetName.getText().isEmpty()) {
					StreetName.setText("Street name");
					StreetName.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		StreetName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(StreetName, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		FTextField City = new FTextField();
		City.setLineColor(new Color(0, 0, 255));
		City.setFont(new Font("Tahoma", Font.PLAIN, 15));
		City.setText("City");
		City.setBounds(394, 157, 297, 34);
		contentPane.add(City);
		City.setColumns(10);
		City.setForeground(new Color(0, 0, 0, 60));
		
		City.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (City.getText().equals("City")) {
					City.setText("");
					City.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (City.getText().isEmpty()) {
					City.setText("City");
					City.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		City.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(City, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		FTextField Town = new FTextField();
		Town.setLineColor(new Color(0, 0, 255));
		Town.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Town.setText("Town");
		Town.setBounds(394, 201, 297, 34);
		contentPane.add(Town);
		Town.setColumns(10);
		Town.setForeground(new Color(0, 0, 0, 60));
		
		Town.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Town.getText().equals("Town")) {
					Town.setText("");
					Town.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Town.getText().isEmpty()) {
					Town.setText("Town");
					Town.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		Town.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(Town, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		FTextField PostalCode = new FTextField();
		PostalCode.setLineColor(new Color(0, 0, 255));
		PostalCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		PostalCode.setText("Postal code");
		PostalCode.setBounds(394, 245, 297, 34);
		contentPane.add(PostalCode);
		PostalCode.setColumns(10);
		PostalCode.setForeground(new Color(0, 0, 0, 60));
		
		PostalCode.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (PostalCode.getText().equals("Postal code")) {
					PostalCode.setText("");
					PostalCode.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (PostalCode.getText().isEmpty()) {
					PostalCode.setText("Postal code");
					PostalCode.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});
		
		PostalCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetterOrDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(PostalCode, "Please enter only letter or digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		JLabel lblNewLabel = new JLabel("If you don't find your medical problem from \r\n");
		lblNewLabel.setForeground(new Color(0, 66, 66));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(45, 392, 253, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" the given list, you can add it by clicking \"ADD\" button");
		lblNewLabel_1.setForeground(new Color(0, 66, 66));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(281, 387, 313, 25);
		contentPane.add(lblNewLabel_1);
		
		RoundedButton btnADD = new RoundedButton("ADD", 20);
		btnADD.setBackground(new Color(119, 215, 221));
		btnADD.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnADD.setBounds(620, 387, 71, 25);
		contentPane.add(btnADD);
		btnADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingNewMedissue enter = new AddingNewMedissue();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel_2 = new JLabel("Please fill in all the required fields");
		lblNewLabel_2.setForeground(new Color(0, 66, 66));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(100, 25, 303, 34);
		contentPane.add(lblNewLabel_2);
		
		
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(677, 22, 38, 25);
		contentPane.add(btnNewButton);
		
		 btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePage enter = new HomePage();
					setVisible(false);
					enter.setVisible(true);
				}
			});
	        
		
		lblNewLabel_3 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Bell.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(55, 10, 46, 52);
		contentPane.add(lblNewLabel_3);
		
		RoundedPanel panel = new RoundedPanel(25, new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(129, 297, 479, 34);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Do you have disability?");
		lblNewLabel_4.setBounds(20, 7, 165, 20);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton Yes_button = new JRadioButton("Yes");
		Yes_button.setBounds(272, 5, 47, 25);
		panel.add(Yes_button);
		Yes_button.setBackground(new Color(255, 255, 255));
		Yes_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disabilityGR.add(Yes_button);
		
		
		
		JRadioButton No_button = new JRadioButton("No");
		No_button.setBounds(365, 5, 43, 25);
		panel.add(No_button);
		No_button.setBackground(new Color(255, 255, 255));
		No_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		disabilityGR.add(No_button);
		
		RoundedPanel panel_1 = new RoundedPanel(25, new Color(255, 206, 206));
		panel_1.setBackground(new Color(255, 206, 206));
		panel_1.setBounds(45, 348, 202, 34);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("Select medical problem ==>");
		lblNewLabel_5.setBackground(new Color(255, 53, 53));
		lblNewLabel_5.setBounds(10, 0, 205, 34);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		
		contentPane.setVisible(true);
		
		RoundedButton Confirm = new RoundedButton("Confirm", 25);
		Confirm.setBackground(new Color(247, 206, 128));
		Confirm.setFont(new Font("Tahoma", Font.BOLD, 16));
		Confirm.setBounds(307, 463, 116, 34);
		contentPane.add(Confirm);
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = Email.getText();
				
				if(FirstName.getText().isEmpty() || FirstName.getText().equals("First name")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your First Name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (Surname.getText().isEmpty() || Surname.getText().equals("Surname")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Surname.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (DateOfBirth.getText().isEmpty() || DateOfBirth.getText().equals("Date of Birth")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Date of Birth.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( TelephoneNumber.getText().isEmpty() || TelephoneNumber.getText().equals("Telephone number")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Telephone number.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (Email.getText().isEmpty() || Email.getText().equals("Email")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Email.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (!(email.contains("@gmail.com") || email.contains("@yahoo.com")
						|| email.contains("@outlook"))) {
					JOptionPane.showMessageDialog(Confirm,
							"Please enter an email address from Gmail, Yahoo, or Outlook.", "Invalid Email",
							JOptionPane.ERROR_MESSAGE);	
				}else if (HouseNumber.getText().isEmpty() || HouseNumber.getText().equals("House number")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your House number.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);	
				}else if (StreetName.getText().isEmpty() || StreetName.getText().equals("Street name")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Street name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( Town.getText().isEmpty() || Town.getText().equals("Town")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Town name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( City.getText().isEmpty() || City.getText().equals("City")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your City name.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if ( PostalCode.getText().isEmpty() || PostalCode.getText().equals("Postal code")) {
					JOptionPane.showMessageDialog(Confirm, "Please enter your Postal code.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else {
					
					
					
					String dateofbirth = DateOfBirth.getText();
					int age = calculateAge(dateofbirth);
					if(age == -1) {
						return;
					}
				
					String message = "Your age is:" + age + ".";
					
					if(age >= 70)
					{
						message += " Congrats!!! <Your age is above 70>  You will be given a free meal once you visit our hospital";
					} else if(age == 13 || age <= 18)
					{
						message += " Warning!!! Dear User <Your age is below 18>  Ensure you are accompanied an adult in the hospital";
					} else if(age < 13)
					{
						message += " Warning!!! Dear User <Your age is below 13>  Make sure you are assigned a paediatrically specialized doctor";
					}
					JOptionPane.showMessageDialog(null, message, "Age information", JOptionPane.INFORMATION_MESSAGE);
				
			Random random = new Random();
			int randomnumber = 10000000 + random.nextInt(90000000);
			
			
			String INSERT = "INSERT INTO patient (Firstname, Surname, Dateofbirth, Telephonenumber, Email, Housenumber, Streetname, Town, City, Postalcode, Disability, randomID, MedProblem) Values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
			try (Connection connect = Database.databaseConn(); PreparedStatement prepare = connect.prepareStatement(INSERT)) 
			{
				prepare.setString(1, FirstName.getText());
				prepare.setString(2, Surname.getText());
				prepare.setString(3, DateOfBirth.getText());
				prepare.setString(4, TelephoneNumber.getText());
				prepare.setString(5, Email.getText());
				prepare.setString(6, HouseNumber.getText());
				prepare.setString(7, StreetName.getText());
				prepare.setString(8, Town.getText());
				prepare.setString(9, City.getText());
				prepare.setString(10, PostalCode.getText());
				String disabilityStatus = Yes_button.isSelected()? "Yes" : "No";
				prepare.setString(11, disabilityStatus);
				prepare.setInt(12, randomnumber);
				prepare.setString(13, (String) combobox.getSelectedItem());
				prepare.executeUpdate();
				
				int option = JOptionPane.showConfirmDialog(null, "<Data saved successfully>. Your visitation ID:" + randomnumber + " Press OK to go to the HOME PAGE", "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
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
			




			




			protected int calculateAge(String dateofbirth) {
				try {
					
					DateTimeFormatter fm = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					LocalDate abc = LocalDate.parse(dateofbirth, fm);
					LocalDate currentDate = LocalDate.now();
					Period period = Period.between(abc, currentDate);
					return period.getYears();
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Incorrect date format: Please use (MM/dd/yyyy.)", "Error", JOptionPane.ERROR_MESSAGE);
					return -1;
				}
			}
		});	
	}
	//    src/
	private void loadProblems() {
		String path = ("src/ailments.csv");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			br.readLine();
			while((line = br.readLine()) != null) {
				String [] values = line.split(",");
				
				if (values.length > 0)  {
					
					String Specialty = values[0];
					combobox.addItem(Specialty);
				
				}
					
				} 
			
			br.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
   }