package MyPack;

import java.awt.Color;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.awt.event.KeyListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

import javax.swing.JList;
import javax.swing.JTable;















public class PreviousVisitorData extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField Surname;
	private JTextField DateOfBirth;
	private JTextField VisitationNumber;
	private JTextField First_Name;
	private JTextField LastName;
	private JTextField DateOf_Birth;
	private JTextField Visitation_Number;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;
	//private  JTextField user_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreviousVisitorData frame = new PreviousVisitorData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public PreviousVisitorData() {
		connection = Database.databaseConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		FTextField First_Name = new FTextField();
		First_Name.setLineColor(new Color(0, 0, 255));
		First_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		First_Name.setText("Input your First Name");
		First_Name.setBounds(59, 121, 245, 45);
		contentPane.add(First_Name);
		First_Name.setColumns(10);
		First_Name.setForeground(new Color(0, 0, 0, 60));

		First_Name.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (First_Name.getText().equals("Input your First Name")) {
					First_Name.setText("");
					First_Name.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (First_Name.getText().isEmpty()) {
					First_Name.setText("Input your First Name");
					First_Name.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});

		First_Name.addKeyListener(new KeyAdapter() {
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

		FTextField LastName = new FTextField();
		LastName.setLineColor(new Color(0, 0, 255));
		LastName.setText("Input your Last Name");
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LastName.setBounds(59, 179, 245, 45);
		contentPane.add(LastName);
		LastName.setColumns(10);
		LastName.setForeground(new Color(0, 0, 0, 60));

		LastName.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (LastName.getText().equals("Input your Last Name")) {
					LastName.setText("");
					LastName.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (LastName.getText().isEmpty()) {
					LastName.setText("Input your Last Name");
					LastName.setForeground(new Color(0, 0, 0, 60));
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

		FTextField DateOf_Birth = new FTextField();
		DateOf_Birth.setLineColor(new Color(0, 0, 255));
		DateOf_Birth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DateOf_Birth.setText("Input your date of birth");
		DateOf_Birth.setBounds(326, 121, 245, 45);
		contentPane.add(DateOf_Birth);
		DateOf_Birth.setColumns(10);
		DateOf_Birth.setForeground(new Color(0, 0, 0, 60));

		DateOf_Birth.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (DateOf_Birth.getText().equals("Input your date of birth")) {
					DateOf_Birth.setText("");
					DateOf_Birth.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (DateOf_Birth.getText().isEmpty()) {
					DateOf_Birth.setText("Input your date of birth");
					DateOf_Birth.setForeground(new Color(0, 0, 0, 60));

				} else {
					SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
					format.setLenient(false);
					try {
						format.parse(DateOf_Birth.getText());
					}catch(ParseException PE) {
						JOptionPane.showMessageDialog(null, "Please enter the date in MM/dd/yyyy format.","Incorrect Date Format", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});


		FTextField Visitation_Number = new FTextField();
		Visitation_Number.setLineColor(new Color(0, 0, 255));
		Visitation_Number.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Visitation_Number.setText("Input visitation number");
		Visitation_Number.setBounds(326, 177, 245, 45);
		contentPane.add(Visitation_Number);
		Visitation_Number.setColumns(10);
		Visitation_Number.setForeground(new Color(0, 0, 0, 60));

		Visitation_Number.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Visitation_Number.getText().equals("Input visitation number")) {
					Visitation_Number.setText("");
					Visitation_Number.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Visitation_Number.getText().isEmpty()) {
					Visitation_Number.setText("Input visitation number");
					Visitation_Number.setForeground(new Color(0, 0, 0, 60));
				}
			}
		});

		Visitation_Number.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isDigit(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(Visitation_Number, "Please enter only digit numbers.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel Previousrecords = new JLabel("If you visited our hospital previously, you can get your information by filling these fields");
		Previousrecords.setFont(new Font("Tahoma", Font.BOLD, 13));
		Previousrecords.setBounds(104, 84, 610, 24);
		contentPane.add(Previousrecords);
		Previousrecords.setForeground(new Color(0, 66, 66));

		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.setBounds(677, 26, 37, 21);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage enter = new HomePage();
				setVisible(false);
				enter.setVisible(true);
			}
		});



		

		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/Bell.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(59, 68, 45, 51);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 255, 691, 183);
		contentPane.add(scrollPane_1);

		table = new JTable();

		scrollPane_1.setViewportView(table);
		
		RoundedButton btnNewButton_1 = new RoundedButton("Clear", 25);
		btnNewButton_1.setBackground(new Color(0, 215, 215));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				PreviousVisitorData enter = new PreviousVisitorData();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(316, 457, 94, 29);
		contentPane.add(btnNewButton_1);
		
		
		RoundedButton btnSearch = new RoundedButton("Search", 25);
		btnSearch.setBackground(new Color(247, 206, 128));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(592, 150, 122, 29);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(First_Name.getText().isEmpty() || First_Name.getText().equals("Input your First Name") ||
						LastName.getText().isEmpty() || LastName.getText().equals("Input your Last Name") ||
						Visitation_Number.getText().isEmpty() || Visitation_Number.getText().equals("Input visitation number") ||
						DateOf_Birth.getText().isEmpty() || DateOf_Birth.getText().equals("Input your date of birth")) {

					JOptionPane.showMessageDialog(null, "Error: Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
				}else if (!Visitation_Number.getText().matches("\\d{8}")) {
					JOptionPane.showMessageDialog(null, "Error: Visitation number must be 8 - digit numbers.", "Error", JOptionPane.ERROR_MESSAGE);
					Visitation_Number.setText("");
				} else {
					First_Name.setVisible(false);
					LastName.setVisible(false);
					DateOf_Birth.setVisible(false);
					Visitation_Number.setVisible(false);

					
					String Select = ("Select Firstname, Surname, Dateofbirth, Telephonenumber, Email, Housenumber, Streetname, Town, City, Postalcode, Disability, randomID, MedProblem from patient WHERE Firstname = ? AND Surname = ? AND Dateofbirth = ? AND randomID = ?");
	
					try
			       ( Connection connect = Database.databaseConn(); PreparedStatement pst = connect.prepareStatement(Select)) 
				   {
						pst.setString(1, First_Name.getText());
						pst.setString(2, LastName.getText());
						pst.setString(3, DateOf_Birth.getText());
						pst.setString(4, Visitation_Number.getText());



						ResultSet RS = pst.executeQuery();

						table.setModel(DbUtils.resultSetToTableModel(RS));
						
						
					}catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error occured in database connection:" + e1.getMessage());

						First_Name.setVisible(true);
						LastName.setVisible(true);
						DateOf_Birth.setVisible(true);
						Visitation_Number.setVisible(true);
					}
				}
			}

		});
			}
	}



				

	
	
			
		





















