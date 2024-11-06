package pharmacy;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class BasketWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private ArrayList<String[]> basketItems;
    private JLabel totalSumLabel;
    private double totalSum = 0.0;

    public BasketWindow(ArrayList<String[]> basketItems) {
        this.basketItems = basketItems;
        setTitle("Basket");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(250, 250, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        totalSumLabel = new JLabel("Total Sum: 0.0");
        totalSumLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        bottomPanel.add(totalSumLabel, BorderLayout.WEST);

        JButton recalculateButton = new JButton("Recalculate Total");
        recalculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateTotal();
            }
        });
        bottomPanel.add(recalculateButton, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });
        bottomPanel.add(checkoutButton, BorderLayout.EAST);

        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        loadBasketData(basketItems);
    }

    private void loadBasketData(ArrayList<String[]> basketItems) {
        DefaultTableModel tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 8; // Only the quantity column is editable
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
        tableModel.addColumn("Quantity");

        // Add basket items to the table
        for (String[] item : basketItems) {
            Object[] rowData = new Object[item.length + 1]; // One extra column for quantity
            System.arraycopy(item, 0, rowData, 0, item.length);
            rowData[item.length] = 1; // Default quantity is 1
            tableModel.addRow(rowData);
        }

        table.setModel(tableModel);
        recalculateTotal();
    }

    private void recalculateTotal() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        totalSum = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String priceStr = tableModel.getValueAt(i, 6) != null ? tableModel.getValueAt(i, 6).toString() : "0.0";
            String quantityStr = tableModel.getValueAt(i, 8) != null ? tableModel.getValueAt(i, 8).toString() : "0";

            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);
            totalSum += price * quantity;
        }
        totalSumLabel.setText("Total Sum: " + totalSum);
    }

    private void checkout() {
        Random random = new Random();
        int transactionId = random.nextInt(90000000) + 10000000;

        StringBuilder invoice = new StringBuilder();
        invoice.append("Purchase Invoice\n");
        invoice.append("Transaction ID: ").append(transactionId).append("\n");
        invoice.append("Total Amount: $").append(totalSum).append("\n\n");
        invoice.append(String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n",
                "Medicine Name", "Composition", "Uses", "Side Effects", "Image URL", "Expire Date", "Price", "Stock", "Quantity"));

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String medicineName = tableModel.getValueAt(i, 0) != null ? tableModel.getValueAt(i, 0).toString() : "";
            String composition = tableModel.getValueAt(i, 1) != null ? tableModel.getValueAt(i, 1).toString() : "";
            String uses = tableModel.getValueAt(i, 2) != null ? tableModel.getValueAt(i, 2).toString() : "";
            String sideEffects = tableModel.getValueAt(i, 3) != null ? tableModel.getValueAt(i, 3).toString() : "";
            String imageUrl = tableModel.getValueAt(i, 4) != null ? tableModel.getValueAt(i, 4).toString() : "";
            String expireDate = tableModel.getValueAt(i, 5) != null ? tableModel.getValueAt(i, 5).toString() : "";
            String price = tableModel.getValueAt(i, 6) != null ? tableModel.getValueAt(i, 6).toString() : "0.0";
            String stock = tableModel.getValueAt(i, 7) != null ? tableModel.getValueAt(i, 7).toString() : "0";
            String quantity = tableModel.getValueAt(i, 8) != null ? tableModel.getValueAt(i, 8).toString() : "0";

            invoice.append(String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-10s\n",
                    medicineName, composition, uses, sideEffects, imageUrl, expireDate, price, stock, quantity));
        }

        JTextArea textArea = new JTextArea(invoice.toString());
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Invoice", JOptionPane.INFORMATION_MESSAGE);
    }

    public ArrayList<String[]> getBasketItems() {
        ArrayList<String[]> updatedBasketItems = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String[] item = new String[tableModel.getColumnCount()];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                item[j] = tableModel.getValueAt(i, j) != null ? tableModel.getValueAt(i, j).toString() : "";
            }
            updatedBasketItems.add(item);
        }
        return updatedBasketItems;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ArrayList<String[]> basketItems = new ArrayList<>(); // Placeholder for actual basket items
                    basketItems.add(new String[]{"Medicine1", "Comp1", "Use1", "Side1", "URL1", "150.0", "100"});
                    basketItems.add(new String[]{"Medicine2", "Comp2", "Use2", "Side2", "URL2", "200.0", "200"});
                    BasketWindow frame = new BasketWindow(basketItems);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
