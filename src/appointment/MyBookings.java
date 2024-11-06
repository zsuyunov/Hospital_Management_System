package appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyBookings extends JFrame {
    private static final String FILE_PATH = "src/appointments.txt";
    private static final String REVIEW_FILE_PATH = "src/review.txt";
    private ArrayList<String> appointmentsList;
    private JPanel mainPanel;
    private JPanel completedPanel;
    private JLabel upcomingTitle;
    private JTextField searchField;
    private JButton searchButton;

    public MyBookings() {
        setTitle("My Bookings");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        JLabel mainTitle = new JLabel("My Bookings", JLabel.CENTER);
        mainTitle.setFont(new Font("Arial", Font.BOLD, 24));
        add(mainTitle, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        // Search bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.setBackground(Color.BLUE);
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshAppointments();
            }
        });
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        mainPanel.add(searchPanel);

        upcomingTitle = new JLabel("Upcoming Bookings", JLabel.CENTER);
        upcomingTitle.setFont(new Font("Arial", Font.BOLD, 18));
        upcomingTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(upcomingTitle);

        appointmentsList = readAppointmentsFromFile();

        for (String appointment : appointmentsList) {
            String[] details = appointment.split(",");
            if (details.length == 6) {
                JPanel appointmentPanel = createAppointmentPanel(details);
                mainPanel.add(appointmentPanel);
            }
        }

        // Completed Booking Panel
        completedPanel = new JPanel();
        completedPanel.setLayout(new BoxLayout(completedPanel, BoxLayout.Y_AXIS));
        completedPanel.setBackground(Color.WHITE);
        JLabel completedLabel = new JLabel("Completed Bookings", JLabel.CENTER);
        completedLabel.setFont(new Font("Arial", Font.BOLD, 18));
        completedPanel.add(completedLabel);

        // Sample Completed Booking with more than one month passed
        completedPanel.add(createCompletedBookingPanel("20th May - 9:00 AM", "TUBA CITY REGIONAL HEALTH CARE CORPORATION", "PO BOX 600", "9282832501", "3"));

        mainPanel.add(completedPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Adjust scroll speed if necessary
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createAppointmentPanel(String[] details) {
        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new BorderLayout());
        appointmentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        appointmentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200)); // Increased height for better visibility

        // Display hospital details
        StringBuilder detailsText = new StringBuilder();
        detailsText.append("<html><b>Name:</b> ").append(details[0]).append("<br>")
                .append("<b>Address:</b> ").append(details[1]).append("<br>")
                .append("<b>Phone:</b> ").append(details[2]).append("<br>")
                .append("<b>Date:</b> ").append(details[4]).append("<br>")
                .append("<b>Time:</b> ").append(details[5]).append("<br>")
                .append("</html>");

        JLabel detailsLabel = new JLabel(detailsText.toString());
        appointmentPanel.add(detailsLabel, BorderLayout.CENTER);

        // Display smaller image (assuming resizing)
        ImageIcon hospitalImage = new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.31.40_36d35f1e.jpg");
        Image scaledImage = hospitalImage.getImage().getScaledInstance(280, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        appointmentPanel.add(imageLabel, BorderLayout.WEST);

        // Buttons panel at the bottom
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Edit button
        JButton editButton = new JButton("Edit");
        editButton.setBackground(Color.BLUE);
        editButton.setForeground(Color.WHITE);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open BookAppointment page with current details pre-filled for editing
                openEditAppointment(details, mainPanel); // Pass mainPanel here
            }
        });
        buttonsPanel.add(editButton);

        // Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this appointment?", "Confirm cancellation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    appointmentsList.remove(String.join(",", details));
                    writeAppointmentsToFile(appointmentsList);
                    refreshAppointments();
                }
            }
        });
        buttonsPanel.add(cancelButton);

        appointmentPanel.add(buttonsPanel, BorderLayout.SOUTH);

        return appointmentPanel;
    }

    private JPanel createCompletedBookingPanel(String dateTime, String name, String address, String phone, String rating) {
        JPanel completedPanel = new JPanel();
        completedPanel.setLayout(new BorderLayout());
        completedPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        completedPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 200)); // Adjust height if necessary

        // Display completed booking details
        StringBuilder detailsText = new StringBuilder();
        detailsText.append("<html>").append(dateTime).append("<br>")
                .append("<b>Name:</b> ").append(name).append("<br>")
                .append("<b>Address:</b> ").append(address).append("<br>")
                .append("<b>Phone:</b> ").append(phone).append("<br>")
                .append("<b>Rating:</b> ").append(rating).append("<br>")
                .append("</html>");

        JLabel detailsLabel = new JLabel(detailsText.toString());
        completedPanel.add(detailsLabel, BorderLayout.CENTER);

        // Display smaller image (assuming resizing)
        ImageIcon hospitalImage = new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.31.40_36d35f1e.jpg");
        Image scaledImage = hospitalImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        completedPanel.add(imageLabel, BorderLayout.WEST);

        // Buttons panel at the bottom
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Re-Book button
        JButton rebookButton = new JButton("Re-Book");
        rebookButton.setBackground(Color.BLUE);
        rebookButton.setForeground(Color.WHITE);
        rebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if 1 month has passed
                if (canRebook(dateTime)) {
                    String[] hospitalDetails = {
                        "", // Placeholder for unused index 0 (assuming hospitalDetails[0] is not used)
                        name,
                        address,
                        "", // Placeholder for unused index 3
                        "", // Placeholder for unused index 4
                        "", // Placeholder for unused index 5
                        "", // Placeholder for unused index 6
                        phone,
                        "", // Placeholder for unused index 8
                        "", // Placeholder for unused index 9
                        "", // Placeholder for unused index 10
                        rating
                    };

                    BookAppointment bookAppointment = new BookAppointment(hospitalDetails,
                    		"C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.31.40_36d35f1e.jpg",
                            false,
                            "", // No old date
                            "", // No old time
                            new AppointmentCallback() {
                                @Override
                                public void onAppointmentUpdated() {
                                    refreshAppointments();
                                }
                            });

                    bookAppointment.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "You can only re-book an appointment if 1 month has passed since the initial appointment.");
                }
            }
        });
        buttonsPanel.add(rebookButton);

        // Add Review button
        JButton addReviewButton = new JButton("Add Review");
        addReviewButton.setBackground(Color.BLUE);
        addReviewButton.setForeground(Color.WHITE);
        addReviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openReviewDialog(name, address, phone);
            }
        });
        buttonsPanel.add(addReviewButton);

        completedPanel.add(buttonsPanel, BorderLayout.SOUTH);

        return completedPanel;
    }

    private void openReviewDialog(String name, String address, String phone) {
        JDialog reviewDialog = new JDialog(this, "Add Review", true);
        reviewDialog.setSize(400, 300);
        reviewDialog.setLayout(new BorderLayout());

        JTextArea reviewArea = new JTextArea(10, 30);
        reviewDialog.add(new JScrollPane(reviewArea), BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String review = reviewArea.getText().trim();
                if (!review.isEmpty()) {
                    saveReview(name, address, phone, review);
                    reviewDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(reviewDialog, "Please enter a review.");
                }
            }
        });
        reviewDialog.add(submitButton, BorderLayout.SOUTH);

        reviewDialog.setLocationRelativeTo(this);
        reviewDialog.setVisible(true);
    }

    private void saveReview(String name, String address, String phone, String review) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REVIEW_FILE_PATH, true))) {
            writer.write(name + "," + address + "," + phone + "," + review);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean canRebook(String dateTime) {
        String dateWithoutSuffix = dateTime.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM - h:mm a");
        try {
            Date appointmentDate = dateFormat.parse(dateWithoutSuffix);
            Date currentDate = new Date();
            long differenceInMilliseconds = currentDate.getTime() - appointmentDate.getTime();
            long daysDifference = differenceInMilliseconds / (1000 * 60 * 60 * 24);
            return daysDifference >= 30;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void openEditAppointment(String[] details, JPanel mainPanel) {
        String[] hospitalDetails = {
            "", // Placeholder for unused index 0 (assuming hospitalDetails[0] is not used)
            details[0], // Name
            details[1], // Address
            "", // Placeholder for unused index 3
            "", // Placeholder for unused index 4
            "", // Placeholder for unused index 5
            "", // Placeholder for unused index 6
            details[2], // Phone
            "", // Placeholder for unused index 8
            "", // Placeholder for unused index 9
            "", // Placeholder for unused index 10
            details[3], // No rating passed for editing
        };

        BookAppointment bookAppointment = new BookAppointment(hospitalDetails,
        		"C:\\Users\\HP\\OneDrive\\Desktop\\appImg\\WhatsApp Image 2024-08-07 at 19.31.40_36d35f1e.jpg",
                true,
                details[4], // Old Date
                details[5], // Old Time
                new AppointmentCallback() {
                    @Override
                    public void onAppointmentUpdated() {
                        refreshAppointments();
                    }
                });

        bookAppointment.setVisible(true);
    }

    private ArrayList<String> readAppointmentsFromFile() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void writeAppointmentsToFile(ArrayList<String> appointmentsList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String appointment : appointmentsList) {
                writer.write(appointment);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void refreshAppointments() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainPanel.removeAll();
                mainPanel.add(searchField.getParent()); // Add search panel back
                mainPanel.add(upcomingTitle); // Add the title back after refreshing
                appointmentsList = readAppointmentsFromFile();

                String searchQuery = searchField.getText().trim().toLowerCase();

                for (String appointment : appointmentsList) {
                    String[] details = appointment.split(",");
                    if (details.length == 6 && (searchQuery.isEmpty() || details[0].toLowerCase().contains(searchQuery))) {
                        JPanel appointmentPanel = createAppointmentPanel(details);
                        mainPanel.add(appointmentPanel);
                    }
                }

                mainPanel.add(completedPanel); // Add completed panel back

                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyBookings();
            }
        });
    }
}


















 
















