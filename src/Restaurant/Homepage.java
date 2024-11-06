package Restaurant;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Homepage window = new Homepage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Homepage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 60));
        frame.getContentPane().setBackground(new Color(192, 192, 192));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(0, 0, 1250, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        JLabel lblNewLabel = new JLabel("Welcome to Restaurant");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 60));
        lblNewLabel.setForeground(new Color(64, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\Screenshots\\Screenshot 2024-07-12 174916.png"));
        
        JButton btnNext = new JButton("Next");
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginpage loginPage = new loginpage();
                loginPage.setVisible(true);
                frame.dispose();
            }
        });

        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 1236, GroupLayout.PREFERRED_SIZE)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(188)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(179)
                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(550)
                    .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                    .addGap(36)
                    .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE))
        );
        frame.getContentPane().setLayout(groupLayout);
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
