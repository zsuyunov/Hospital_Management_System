import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MyPack.LoginPage;
import Restaurant.loginpage;
import appointment.CreateAccountPage;
import appointment.SignInPage;
import pharmacy.LoginScreen;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;



class RoundedPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private int cornerRadius;

	public RoundedPanel(int radius, Color bgColor) {
		super();
		cornerRadius = radius;
		backgroundColor = bgColor;
		setOpaque(false); // Make the panel transparent
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(backgroundColor);
		graphics.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
	}

	
}







class RoundedButton extends JButton {
	private static final long serialVersionUID = 1L;
	private int cornerRadius; // Corner radius for rounded corners

	public RoundedButton(String label, int radius) {
		super(label);
		cornerRadius = radius;
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Button is pressed
		if (getModel().isPressed()) {
			g2.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			g2.setColor(getBackground().brighter());
		} else {
			g2.setColor(getBackground());
		}

		g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// No border is painted
	}

	@Override
	public boolean contains(int x, int y) {
		// This method could be overridden to match the rounded shape if needed
		return super.contains(x, y);
	}

}






public class mainDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainDashboard frame = new mainDashboard();
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
	public mainDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 151, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundedPanel panel = new RoundedPanel(25, new Color(0, 232, 232) );
		panel.setBackground(new Color(87, 255, 130));
		panel.setBounds(47, 89, 211, 360);
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedButton btnappoinment = new RoundedButton("Appoinment", 25);
		btnappoinment.setBackground(new Color(255, 66, 66));
		btnappoinment.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnappoinment.setBounds(28, 36, 154, 52);
		panel.add(btnappoinment);
		
		btnappoinment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountPage enter = new CreateAccountPage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		RoundedButton btnpatient = new RoundedButton("Patient Info", 25);
		btnpatient.setBackground(new Color(255, 66, 66));
		btnpatient.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpatient.setBounds(28, 120, 154, 52);
		panel.add(btnpatient);
		
		btnpatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage enter = new LoginPage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		
		
		RoundedButton btnpharmacy = new RoundedButton("Pharmacy", 25);
		btnpharmacy.setBackground(new Color(255, 66, 66));
		btnpharmacy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnpharmacy.setBounds(28, 202, 154, 52);
		panel.add(btnpharmacy);
		

		btnpharmacy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen enter = new LoginScreen();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		RoundedButton btnrestaurant = new RoundedButton("Restaurant", 25);
		btnrestaurant.setBackground(new Color(255, 66, 66));
		btnrestaurant.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnrestaurant.setBounds(28, 278, 154, 52);
		panel.add(btnrestaurant);
		
		btnrestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginpage enter = new loginpage();
				setVisible(false);
				enter.setVisible(true);
			}
		});
		
		RoundedPanel panel_1 = new RoundedPanel(25, new Color(0, 232, 232) );
		panel_1.setBackground(new Color(0, 232, 232));
		panel_1.setBounds(297, 89, 398, 360);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 0, 378, 350);
		panel_1.add(lblNewLabel_3);
		Image imgGO3 = new ImageIcon(this.getClass().getResource("/Doctor in white coat holding documents in front of a hospital bed.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(imgGO3));
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Hospital Center");
		lblNewLabel_2.setBounds(460, 26, 378, 53);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Welcome To");
		lblNewLabel.setBounds(146, 31, 144, 42);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Brunel University");
		lblNewLabel_1.setBounds(280, 26, 191, 53);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		
		
		
		
		
	}

}
