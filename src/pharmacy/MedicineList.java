package pharmacy;
import java.awt.EventQueue;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;

public class MedicineList extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;
    private ArrayList<String[]> basketItems = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MedicineList frame = new MedicineList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MedicineList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(176, 163, 1009, 488);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        String[] medicineDetails = new String[8];
                        for (int i = 0; i < 8; i++) {
                            medicineDetails[i] = target.getValueAt(row, i).toString();
                        }
                        MedicineDetailsWindow detailsFrame = new MedicineDetailsWindow(medicineDetails, MedicineList.this);
                        detailsFrame.setVisible(true);
                        setVisible(false); // Hide current frame
                    }
                }
            }
        });

        JLabel lblNewLabel = new JLabel("INVENTORY > MEDICINE LIST");
        lblNewLabel.setBackground(new Color(0, 255, 0));
        lblNewLabel.setBounds(176, 105, 200, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture2.png"));
        lblNewLabel_1.setBounds(26, 10, 51, 94);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture3.png"));
        lblNewLabel_2.setBounds(121, 32, 165, 72);
        contentPane.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(507, 63, 390, 41);
        contentPane.add(textField);

        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setBackground(Color.GREEN);
        btnSearch.setBounds(949, 73, 85, 21);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    performSearch();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(MedicineList.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        contentPane.add(btnSearch);

        JButton btnNewButton = new JButton("DASHBOARD");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DashboardFrame enter = new DashboardFrame();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton.setBackground(new Color(0, 255, 0));
        btnNewButton.setBounds(10, 161, 137, 21);
        contentPane.add(btnNewButton);

        JButton btnNewButton_5 = new JButton("LOGOUT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginScreen enter = new LoginScreen();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton_5.setBackground(Color.RED);
        btnNewButton_5.setBounds(1135, 32, 104, 21);
        contentPane.add(btnNewButton_5);

        JTextArea txtrDoubleClickOn = new JTextArea();
        txtrDoubleClickOn.setText("Double Click on the Medicine to view the Details");
        txtrDoubleClickOn.setBounds(176, 132, 398, 22);
        contentPane.add(txtrDoubleClickOn);

        JButton btnNewButton_2 = new JButton("SALES ");
        btnNewButton_2.setBackground(Color.GREEN);
        btnNewButton_2.setBounds(10, 291, 137, 21);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("NOTIFICATIONS");
        btnNewButton_3.setBackground(Color.GREEN);
        btnNewButton_3.setBounds(10, 384, 137, 21);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("APPLICATION SETTINGS");
        btnNewButton_4.setBackground(Color.GREEN);
        btnNewButton_4.setBounds(10, 470, 137, 21);
        contentPane.add(btnNewButton_4);

        JButton btnAdd = new JButton("ADD MEDICINE");
        btnAdd.setBackground(new Color(255, 128, 128));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.setBounds(1100, 85, 156, 41);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMedInterface();
            }
        });

        JButton btnNewButton_6 = new JButton("BACK");
        btnNewButton_6.setBackground(new Color(0, 255, 0));
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DashboardFrame enter = new DashboardFrame();
                setVisible(false);
                enter.setVisible(true);
            }
        });
        btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_6.setBounds(33, 582, 85, 21);
        contentPane.add(btnNewButton_6);

        JButton btnAddToBasket = new JButton("");
        btnAddToBasket.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\MYGUIGROUPPROJECT\\src\\pharmacyimages\\Picture10.png"));
        btnAddToBasket.setBackground(new Color(255, 255, 255));
        btnAddToBasket.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAddToBasket.setBounds(367, 84, 85, 41);
        contentPane.add(btnAddToBasket);
        
        JTextPane txtpnClickOnThe = new JTextPane();
        txtpnClickOnThe.setText("Click on the Medicine name once to add it cart, and click on cart icon to add it to cart,come back  and repeat for adding Another medicine");
        txtpnClickOnThe.setBounds(297, 10, 324, 53);
        contentPane.add(txtpnClickOnThe);
        btnAddToBasket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToBasket();
            }
        });

        loadMedicineData();
    }

    private void addMedInterface() {
        AddMedicine addmedicine = new AddMedicine();
        addmedicine.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addmedicine.setVisible(true);
    }

    private void addItemToBasket() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String[] selectedItem = new String[8];
            for (int i = 0; i < 8; i++) {
                selectedItem[i] = table.getValueAt(selectedRow, i).toString();
            }
            basketItems.add(selectedItem);
            BasketWindow basketWindow = new BasketWindow(basketItems);
            basketWindow.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to add to the basket.", "No Item Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void loadMedicineData() {
        String myfile = "src/medicine-details.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(myfile));
            String line;
            DefaultTableModel tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // All cells are not editable
                }
            };

            // Add columns
            tableModel.addColumn("Medicine Name");
            tableModel.addColumn("Composition");
            tableModel.addColumn("Uses");
            tableModel.addColumn("Side Effects");
            tableModel.addColumn("Image URL");
            tableModel.addColumn("Expire Date");
            tableModel.addColumn("Price");
            tableModel.addColumn("Stock");

            // Read data from CSV and add rows
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 8) {
                    tableModel.addRow(new Object[]{values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]});
                }
            }
            br.close();
            table.setModel(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void performSearch() throws Exception {
        try {
            File f = new File("src/medicine-details.csv");
            Scanner reader = new Scanner(f);

            // Create a new table model
            DefaultTableModel table_model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // All cells are not editable
                }
            };

            // Create columns
            table_model.addColumn("Medicine Name");
            table_model.addColumn("Composition");
            table_model.addColumn("Uses");
            table_model.addColumn("Side Effects");
            table_model.addColumn("Image URL");
            table_model.addColumn("Expire Date");
            table_model.addColumn("Price");
            table_model.addColumn("Stock");

            // Scan each line of the CSV
            while (reader.hasNext()) {
                String row = reader.nextLine();
                String[] columns = row.split(",");
                if (columns.length < 8) {
                    continue; // Skip rows that don't have enough columns
                }

                String name = columns[0].toLowerCase();
                String composition = columns[1].toLowerCase();
                String uses = columns[2].toLowerCase();
                String sideEffects = columns[3].toLowerCase();
                String imageurl = columns[4].toLowerCase();
                String expDate = columns[5].toLowerCase();
                String priceCol = columns[6].toLowerCase();
                String stockCol = columns[7].toLowerCase();

                // Check if the input matches any column
                if (name.contains(textField.getText().toLowerCase())
                        || composition.contains(textField.getText().toLowerCase())
                        || uses.contains(textField.getText().toLowerCase())
                        || sideEffects.contains(textField.getText().toLowerCase())
                        || imageurl.contains(textField.getText().toLowerCase())
                        || expDate.contains(textField.getText().toLowerCase())
                        || priceCol.contains(textField.getText().toLowerCase())
                        || stockCol.contains(textField.getText().toLowerCase())) {
                    table_model.addRow(new Object[]{name, composition, uses, sideEffects, imageurl, expDate, priceCol, stockCol});
                }
            }

            reader.close();
            table.setModel(table_model);
        } catch (FileNotFoundException e1) {
            throw new Exception("File not found: " + e1.getMessage());
        } catch (Exception e2) {
            throw new Exception("An error occurred: " + e2.getMessage());
        }
    }
}
