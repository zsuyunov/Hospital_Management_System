package MyPack;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;












public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPatientInformation;
	private JButton btnGO1;
	private JButton btnGO2;
	private JButton btnGO3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel FirstPanel;
	private JPanel SecondPanel;
	private JPanel ThirdPanel;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton;
	private String imgGO1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image img3 = new ImageIcon(this.getClass().getResource("/Patients-icon.png")).getImage();
		



		lblNewLabel_2 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/Browndoctor.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(410, 49, 316, 484);
		contentPane.add(lblNewLabel_2);
		Image img11 = new ImageIcon(this.getClass().getResource("/young doctor with clipboard.png")).getImage();
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(img11));
		lblNewLabel_3.setBounds(390, 62, 165, 461);
		contentPane.add(lblNewLabel_3);
		
		RoundedPanel FirstPanel = new RoundedPanel(30, new Color(119, 215, 221));
		FirstPanel.setBackground(new Color(119, 215, 221));
		FirstPanel.setBounds(36, 31, 308, 141);
		contentPane.add(FirstPanel);
		FirstPanel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(24, 25, 120, 92);
		FirstPanel.add(lblNewLabel_9);
		Image imgGO3 = new ImageIcon(this.getClass().getResource("/GO1.png")).getImage();
		lblNewLabel_9.setIcon(new ImageIcon(imgGO3));
		
		JLabel lblNewLabel_6 = new JLabel("Patient Information");
		lblNewLabel_6.setBounds(154, 25, 144, 54);
		FirstPanel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		RoundedButton btnGO1_1 = new RoundedButton("GO", 25);
		btnGO1_1.setBounds(198, 89, 71, 28);
		FirstPanel.add(btnGO1_1);
		btnGO1_1.setBackground(new Color(247, 206, 128));
		btnGO1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnGO1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientInfoPage enter = new PatientInfoPage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
		
		RoundedPanel SecondPanel = new RoundedPanel(30, new Color(119, 215, 221));
		SecondPanel.setBackground(new Color(119, 215, 221));
		SecondPanel.setBounds(36, 199, 308, 141);
		contentPane.add(SecondPanel);
		SecondPanel.setLayout(null);
		
		
		
		
		RoundedButton btnGO2_1 = new RoundedButton("GO", 25);
		btnGO2_1.setBounds(202, 85, 71, 29);
		SecondPanel.add(btnGO2_1);
		btnGO2_1.setVerticalTextPosition(SwingConstants.TOP);
		btnGO2_1.setVerticalAlignment(SwingConstants.TOP);
		btnGO2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGO2_1.setBackground(new Color(247, 206, 128)); 
		
		JLabel lblNewLabel_7 = new JLabel("Next of kin details");
		lblNewLabel_7.setBounds(160, 46, 139, 13);
		SecondPanel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(21, 16, 129, 104);
		SecondPanel.add(lblNewLabel_10);
		Image imgGO2 = new ImageIcon(this.getClass().getResource("/GO1-icon.png")).getImage();
		lblNewLabel_10.setIcon(new ImageIcon(imgGO2));
		
		btnGO2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextofKininfo enter = new NextofKininfo();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
				
		
		RoundedPanel ThirdPanel = new RoundedPanel(30, new Color(119, 215, 221));
		ThirdPanel.setBackground(new Color(119, 215, 221));
		ThirdPanel.setBounds(36, 366, 308, 141);
		contentPane.add(ThirdPanel);
		ThirdPanel.setLayout(null);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(10, 25, 121, 94);
		ThirdPanel.add(lblNewLabel_11);
		lblNewLabel_11.setIcon(new ImageIcon(img3));
		
		JLabel lblNewLabel_8 = new JLabel("Previous visitor data");
		lblNewLabel_8.setBounds(141, 45, 146, 13);
		ThirdPanel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		
		
		RoundedButton btnGO3_1 = new RoundedButton("GO", 25);
		btnGO3_1.setBounds(202, 91, 71, 28);
		ThirdPanel.add(btnGO3_1);
		btnGO3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGO3_1.setBackground(new Color(247, 206, 128));
		
		btnGO3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreviousVisitorData enter = new PreviousVisitorData();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
        Image img2 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
        btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.setBounds(671, 20, 39, 23);
		contentPane.add(btnNewButton);
		
		 btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginPage enter = new LoginPage();
					setVisible(false);
					enter.setVisible(true);
				}
			});
	        
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
