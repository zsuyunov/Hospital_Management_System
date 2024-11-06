package MyPack;

import java.awt.Color;

import java.io.BufferedWriter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;








public class AddingNewMedissue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Specialty;
	private JTextField Description;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingNewMedissue frame = new AddingNewMedissue();
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
	public AddingNewMedissue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FTextField Specialty = new FTextField();
		Specialty.setLineColor(new Color(0, 0, 255));
		Specialty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Specialty.setText("Write specialety of your medical problem");
		Specialty.setBounds(139, 263, 467, 41);
		contentPane.add(Specialty);
		Specialty.setColumns(10);
		Specialty.setForeground(new Color(0, 0, 0, 60));
		
		
		Specialty.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Specialty.getText().equals("Write specialety of your medical problem")) {
					Specialty.setText("");
					Specialty.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Specialty.getText().isEmpty()) {
					Specialty.setText("Write specialety of your medical problem");
					Specialty.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		Specialty.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(Specialty, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		FTextField Description = new FTextField();
		Description.setLineColor(new Color(0, 0, 255));
		Description.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Description.setText("Write a short description about your medical problem");
		Description.setBounds(139, 317, 467, 41);
		contentPane.add(Description);
		Description.setColumns(10);
		Description.setForeground(new Color(0, 0, 0, 60));
		
		Description.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				if (Description.getText().equals("Write a short description about your medical problem")) {
					Description.setText("");
					Description.setForeground(Color.BLACK);
				}

			}

			public void focusLost(FocusEvent e) {
				if (Description.getText().isEmpty()) {
					Description.setText("Write a short description about your medical problem");
					Description.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});
		
		
		
		Description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				// Allow letters, space, backspace, and delete key
				if (!(Character.isLetter(c) || Character.isSpaceChar(c) || c == KeyEvent.VK_BACK_SPACE
						|| c == KeyEvent.VK_DELETE)) {
					e.consume(); // Ignore this key event
					JOptionPane.showMessageDialog(Description, "Please enter only letters.", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/hospital-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(314, -17, 330, 313);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setBounds(674, 22, 38, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientInfoPage enter = new PatientInfoPage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
		RoundedButton btnConfirm = new RoundedButton("Confirm", 25);
		btnConfirm.setBackground(new Color(247, 206, 128));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConfirm.setBounds(299, 390, 122, 33);
		contentPane.add(btnConfirm);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Specialty.getText().isEmpty() || Specialty.getText().equals("Write specialety of your medical problem")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please write Specialty.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else if (Description.getText().isEmpty() || Description.getText().equals("Write a short description about your medical problem")) {
					JOptionPane.showMessageDialog(btnConfirm, "Please enter your Description.", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				}else{
					saveData(Specialty.getText(), Description.getText());
					
					PatientInfoPage enter = new PatientInfoPage();
					setVisible(false);
					enter.setVisible(true);
				}
			}
		});
	}
		
	
	private void saveData(String specialty, String description) {
		
		String path = "src/ailments.csv";
	    try (FileWriter FW = new FileWriter(path, true);
	    	 PrintWriter PW = new PrintWriter(FW)) {
	    	PW.println(specialty + "-->" + description);
	    	
	    	JOptionPane.showMessageDialog(null, "Data saved successfully");
	    }catch(IOException e) {
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "Error saving data" + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
	    }
		
	}

}
