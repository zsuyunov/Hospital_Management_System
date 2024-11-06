package MyPack;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



 






 
 
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

 
 
class FTextField extends JTextField{
    private Color fillColor;
    private Color lineColor;
    private int strokeWidth;
       
    public FTextField() {
        fillColor = new Color(236, 240, 241);
        lineColor = new Color(52, 152, 219);
        strokeWidth = 2;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque()) {            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int s = strokeWidth;
            int w = getWidth() - (2 * s);
            int h = getHeight() - (2 * s);
            g2d.setColor(fillColor);
            g2d.fillRoundRect(s, s, w, h, h, h);
            g2d.setStroke(new BasicStroke(s));
            g2d.setColor(lineColor);
            g2d.drawRoundRect(s, s, w, h, h, h);
        }
        super.paintComponent(g);        
    }

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
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

 
 
 
 
 
 
 
 


public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;
	private JPanel MainPanel_1;
	private JLabel SignInTo;
	private JLabel ForgotPass;
	private JLabel TextAccHave;
	private JLabel lmageBack;
	private JLabel lmage;
	private JLabel User;
	private JLabel Lock;
	private JLabel RectngleUser;
	private JLabel PasswordRectangle;
	private JLabel PasswordRevealIcon;
	private Connection connect;
	private PreparedStatement prepare;
	private ResultSet result;
	private JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		 public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 750, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(114, 142, 244));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Username section
		
		FTextField Username = new FTextField();
		Username.setLineColor(new Color(0, 0, 255));
		Username.setBackground(new Color(245, 233, 233));
		Username.setText("Username");
		Username.setMargin(new Insets(0, 0, 0, 0));
		Username.setForeground(new Color(0, 0, 0, 60));
		Username.setToolTipText("Please, enter your Email");
		Username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Username.setBounds(211, 250, 292, 40);
		contentPane.add(Username);
		Username.setColumns(10);

		Username.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (Username.getText().equals("Username")) {
					Username.setText("");
					Username.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {
				if (Username.getText().isEmpty()) {
					Username.setText("Username");
					Username.setForeground(new Color(0, 0, 0, 50));
				}
			}
		});

		Username.setInputVerifier(new InputVerifier() {
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
		
		
		
		//Password section
		
		FTextField Password = new FTextField();
		Password.setLineColor(new Color(0, 0, 255));
		Password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Password.setToolTipText("Please, enter your Password");
		Password.setMargin(new Insets(0, 0, 0, 0));
		Password.setForeground(new Color(0, 0, 0, 60));
		Password.setColumns(10);
		Password.setBackground(new Color(245, 233, 233));
		Password.setBounds(211, 300, 292, 40);
		contentPane.add(Password);
		
		Password.setText("Password");
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
		

		
		
		
		
		//Sign in button
		
		RoundedButton Signin = new RoundedButton("Sign in", 25);
		Signin.setFont(new Font("Tahoma", Font.BOLD, 18));
		Signin.setBounds(211, 408, 292, 34);
		contentPane.add(Signin);
		Signin.setBackground(new Color(247, 206, 128));
				Signin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						try {
							String query = "SELECT * FROM users WHERE email = ? AND password = ?";
							Connection connect = LogDatabase.connectionDB();
							PreparedStatement prepare = connect.prepareStatement(query);
							prepare.setString(1, Username.getText());
							prepare.setString(2, Password.getText());
							ResultSet result = prepare.executeQuery();

							if (result.next()) {
								JOptionPane.showMessageDialog(null, "Login Successful!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
								HomePage enter = new HomePage();
								dispose();
								enter.setVisible(true); // Shows the user home page

							} else {
								JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Error",
								JOptionPane.ERROR_MESSAGE);
							}

						} catch (SQLException ex) {
							ex.printStackTrace();
							    JOptionPane.showMessageDialog(null, "An error occurred while accessing the database.", "Error",
								JOptionPane.ERROR_MESSAGE);
						}
					}

				});

		
		//Forgot Password? Section
		
		JLabel ForgotPass = new JLabel("Forgot Password?");
		ForgotPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		ForgotPass.setBounds(397, 339, 101, 20);
		contentPane.add(ForgotPass);
		ForgotPass.setForeground(new Color(0, 106, 106));
		ForgotPass.setText("Forgot Password?");
		ForgotPass.setBackground(new Color(223, 12, 12));
		
		ForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				RecoveryPage enter = new RecoveryPage();

				enter.setVisible(true);
			}
		});

		
		// Don't have an account? Create an account
		
		JLabel CreateAcc = new JLabel("Don't have an account? Create an account");
		CreateAcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		CreateAcc.setBounds(240, 444, 263, 13);
		contentPane.add(CreateAcc);
	    CreateAcc.setText("Don't have an account? Create an account");
		CreateAcc.setForeground(new Color(0, 106, 106));
		CreateAcc.setBackground(new Color(13, 146, 118));
		        
		CreateAcc.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				SignUpPage enter = new SignUpPage();

				enter.setVisible(true);
			}
		});        
		        
		        
		        
		        //  JLabel for Logo
		
		        JLabel lblNewLabel1 = new JLabel("");
		        Image img = new ImageIcon(this.getClass().getResource("/Brunel.png")).getImage();
		        lblNewLabel1.setIcon(new ImageIcon(img));
		        lblNewLabel1.setBounds(197, 36, 320, 170);
		        contentPane.add(lblNewLabel1);
		        
		        //Back button
		        
		        btnNewButton = new JButton("");
		        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		        btnNewButton.setBackground(new Color(255, 255, 255));
		        Image img1 = new ImageIcon(this.getClass().getResource("/Back.png")).getImage();
		        btnNewButton.setIcon(new ImageIcon(img1));
		        btnNewButton.setBounds(679, 32, 36, 26);
		        contentPane.add(btnNewButton);
		        
		        btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//mainDashboard enter = new mainDashboard();
						setVisible(false);
						//enter.setVisible(true);
					}
				});
  
		        
		        

	}

}
