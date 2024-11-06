package pharmacy;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class DashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JTextField textField;
//	private JTable table;
    private JTextField user_input;
//    private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardFrame frame = new DashboardFrame();
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
	public DashboardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture2.png"));
		lblNewLabel.setBounds(27, 10, 51, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture3.png"));
		lblNewLabel_1.setBounds(115, 26, 160, 61);
		contentPane.add(lblNewLabel_1);
		
//		textField = new JTextField();
//		textField.setBounds(403, 49, 390, 41);
//		contentPane.add(textField);
//		textField.setColumns(10);
		
		 user_input = new JTextField();
	        user_input.setBounds(403, 49, 390, 41);
	        contentPane.add(user_input);
	        user_input.setColumns(10);
		
//		JButton btnNewButton = new JButton("SEARCH");
//		btnNewButton.setForeground(new Color(0, 0, 0));
//		btnNewButton.setBackground(new Color(0, 255, 0));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton.setBounds(836, 59, 85, 21);
//		contentPane.add(btnNewButton);
	        JButton btnSearch = new JButton("SEARCH");
	        btnSearch.setForeground(new Color(0, 0, 0));
	        btnSearch.setBackground(new Color(0, 255, 0));
	        btnSearch.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    performSearch();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(DashboardFrame.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
	        btnSearch.setBounds(836, 59, 85, 21);
	        contentPane.add(btnSearch);

	        // Scroll pane and table for search results
//	        scrollPane = new JScrollPane();
//	        scrollPane.setBounds(403, 100, 520, 400);
//	        contentPane.add(scrollPane);
//
//	        table = new JTable();
//	        scrollPane.setViewportView(table);
	             
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture4.png"));
		btnNewButton_1.setBounds(233, 132, 221, 61);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture6.png"));
		lblNewLabel_2.setBounds(268, 272, 320, 81);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture7.png"));
		lblNewLabel_3.setBounds(714, 267, 320, 90);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture8.png"));
		lblNewLabel_4.setBounds(268, 454, 333, 81);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture9.png"));
		lblNewLabel_5.setBounds(718, 456, 326, 76);
		contentPane.add(lblNewLabel_5);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 255, 0));
		menuBar.setBounds(10, 202, 115, 26);

		JMenu mnInventory = new JMenu("INVENTORY");
		mnInventory.setHorizontalAlignment(SwingConstants.CENTER);
		mnInventory.setBackground(new Color(0, 255, 0));
		menuBar.add(mnInventory);




		JMenuItem mntmMedicineList = new JMenuItem("MEDICINE LIST");
		mntmMedicineList.setBackground(new Color(0, 255, 0));
        mntmMedicineList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the MedicineListFrame
                MedicineList medicineListFrame = new MedicineList();
                medicineListFrame.setVisible(true);
                setVisible(false); 
                

        		
               
            }
        });
        mnInventory.add(mntmMedicineList);
		contentPane.add(menuBar);
		
		JButton btnNewButton = new JButton("DASHBOARD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DashboardFrame enter = new DashboardFrame();
	                setVisible(false);
	                enter.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(10, 152, 137, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("SALES ");
		btnNewButton_2.setBackground(new Color(0, 255, 0));
		btnNewButton_2.setBounds(10, 272, 137, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("NOTIFICATIONS");
		btnNewButton_3.setBackground(new Color(0, 255, 0));
		btnNewButton_3.setBounds(10, 348, 137, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("APPLICATION SETTINGS");
		btnNewButton_4.setBackground(new Color(0, 255, 0));
		btnNewButton_4.setBounds(10, 430, 137, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("LOGOUT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginScreen enter = new LoginScreen();
                setVisible(false);
                enter.setVisible(true);
				
			}
		});
		btnNewButton_5.setBackground(new Color(255, 0, 0));
		btnNewButton_5.setBounds(1131, 10, 104, 21);
		contentPane.add(btnNewButton_5);
		
		JTextArea txtrSearchHereFor = new JTextArea();
		txtrSearchHereFor.setText("SEARCH HERE FOR THER MEDICINE DETAILS");
		txtrSearchHereFor.setBounds(439, 28, 301, 22);
		contentPane.add(txtrSearchHereFor);
		
		
           

		
	}
	

private void performSearch() throws Exception {
    try {
        File f = new File("src/medicine-details (1).csv");
        Scanner reader = new Scanner(f);

        // Create a new table model
        DefaultTableModel table_model = new DefaultTableModel();
        // table.setModel(table_model);

        // Create columns
        table_model.addColumn("Medicine Name");
        table_model.addColumn("Composition");
        table_model.addColumn("Uses");
        table_model.addColumn("Side Effects");
        table_model.addColumn("Image URL");

        // Scan each line of the CSV
        while (reader.hasNext()) {
            String row = reader.nextLine();
            String[] columns = row.split(",");
            if (columns.length < 10) {
                continue; // Skip rows that don't have enough columns
            }

            String name = columns[0].toLowerCase();
            String composition = columns[1].toLowerCase();
            String uses = columns[2].toLowerCase();
            String sideEffects = columns[3].toLowerCase();
            String manufacturer = columns[10].toLowerCase();

            // Check if the input matches any column
            if (name.contains(user_input.getText().toLowerCase())
                    || composition.contains(user_input.getText().toLowerCase())
                    || uses.contains(user_input.getText().toLowerCase())
                    || sideEffects.contains(user_input.getText().toLowerCase())
                    || manufacturer.contains(user_input.getText().toLowerCase())) {
                table_model.addRow(new Object[]{name, composition, uses, sideEffects, manufacturer});
            }
        }

        reader.close();
        JTable table = new JTable(table_model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Set bounds for the scroll pane
        scrollPane.setBounds(403, 100, 520, 400);

        // Add the scroll pane with the results to the content pane
        contentPane.add(scrollPane);
        contentPane.setComponentZOrder(scrollPane, 0); // Bring scrollPane to the front
        contentPane.revalidate();
        contentPane.repaint();

        // Add mouse listener to collapse the scroll pane when clicking anywhere on the screen
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the scroll pane is present
                if (SwingUtilities.isDescendingFrom(scrollPane, contentPane)) {
                    contentPane.remove(scrollPane);
                    contentPane.revalidate();
                    contentPane.repaint();
                }
            }
        });
    } catch (FileNotFoundException e1) {
        throw new Exception("File not found: " + e1.getMessage());
    } catch (Exception e2) {
        throw new Exception("An error occurred: " + e2.getMessage());
    }
}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
