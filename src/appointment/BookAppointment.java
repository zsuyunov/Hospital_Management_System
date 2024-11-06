package appointment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BookAppointment extends JFrame {
    private JButton[] dateButtons;
    private JButton[] timeButtons;
    private String selectedDate = null;
    private String selectedTime = null;
    private JLabel errorLabel;
    private String[] hospitalDetails;
    private boolean isEditMode;
    private String oldDate;
    private String oldTime;
    private AppointmentCallback callback;

    private static final String FILE_PATH = "src/appointments.txt";

    public BookAppointment(String[] hospital, String imagePath) {
        this(hospital, imagePath, false, null, null, null);
    }

    public BookAppointment(String[] hospital, String imagePath, boolean isEditMode, String oldDate, String oldTime, AppointmentCallback callback) {
        hospitalDetails = hospital;
        this.isEditMode = isEditMode;
        this.oldDate = oldDate;
        this.oldTime = oldTime;
        this.callback = callback;

        setTitle(isEditMode ? "Edit Appointment" : "Book Appointment");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.WHITE);

        JLabel heading = new JLabel(isEditMode ? "Edit Appointment" : "Book Appointment", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(heading);

        JPanel detailsPanel = new JPanel(new BorderLayout());
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsPanel.setBackground(Color.WHITE);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(0, 1));
        textPanel.setBackground(Color.WHITE);

        JLabel detailsHeading = new JLabel("Hospital Details");
        detailsHeading.setFont(new Font("Arial", Font.BOLD, 18));
        detailsHeading.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.add(detailsHeading);

        JLabel nameLabel = new JLabel("Name: " + hospital[1]);
        JLabel addressLabel = new JLabel("Address: " + hospital[2]);
        JLabel phoneNumberLabel = new JLabel("Ph no.: " + hospital[7]);
        JLabel ratingLabel = new JLabel("Rating: " + hospital[11]);

        textPanel.add(nameLabel);
        textPanel.add(addressLabel);
        textPanel.add(phoneNumberLabel);
        textPanel.add(ratingLabel);

        detailsPanel.add(textPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);

        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(image));

        imagePanel.add(imageLabel);
        detailsPanel.add(imagePanel, BorderLayout.EAST);

        mainPanel.add(detailsPanel);

        JPanel bookingPanel = new JPanel(new GridLayout(2, 1));
        bookingPanel.setBackground(Color.WHITE);

        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.setBackground(Color.WHITE);
        datePanel.setBorder(BorderFactory.createTitledBorder(null, "Date", 0, 0, new Font("Arial", Font.BOLD, 16)));

        dateButtons = new JButton[6];
        String[] dates = generateCurrentDates(); // Get current dates dynamically

        for (int i = 0; i < dateButtons.length; i++) {
            dateButtons[i] = new JButton(dates[i]);
            dateButtons[i].setPreferredSize(new Dimension(130, 40));
            dateButtons[i].setFont(new Font("Arial", Font.BOLD, 12));
            dateButtons[i].setForeground(Color.decode("#003166"));
            dateButtons[i].setBackground(Color.decode("#FBFBFB"));
            dateButtons[i].addActionListener(new DateButtonActionListener());
            datePanel.add(dateButtons[i]);
        }

        bookingPanel.add(datePanel);

        JPanel timePanel = new JPanel(new FlowLayout());
        timePanel.setBackground(Color.WHITE);
        timePanel.setBorder(BorderFactory.createTitledBorder(null, "Time", 0, 0, new Font("Arial", Font.BOLD, 16)));

        timeButtons = new JButton[6];
        String[] times = {"09:00 AM", "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM", "03:00 PM"}; // Fixed times for example

        for (int i = 0; i < timeButtons.length; i++) {
            timeButtons[i] = new JButton(times[i]);
            timeButtons[i].setPreferredSize(new Dimension(130, 40));
            timeButtons[i].setFont(new Font("Arial", Font.BOLD, 12));
            timeButtons[i].setForeground(Color.decode("#003166"));
            timeButtons[i].setBackground(Color.decode("#FBFBFB"));
            timeButtons[i].addActionListener(new TimeButtonActionListener());
            timePanel.add(timeButtons[i]);
        }

        bookingPanel.add(timePanel);

        mainPanel.add(bookingPanel);

        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setFont(new Font("Arial", Font.BOLD, 12));
        errorLabel.setForeground(Color.RED);
        mainPanel.add(errorLabel);

        JButton bookButton = new JButton(isEditMode ? "Update Appointment" : "Book Appointment");
        bookButton.setPreferredSize(new Dimension(200, 40));
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        bookButton.setForeground(Color.WHITE);
        bookButton.setBackground(Color.decode("#005DA4"));
        bookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedDate == null || selectedTime == null) {
                    errorLabel.setText("Please select a date and time.");
                } else {
                    if (isEditMode) {
                        updateAppointmentInFile();
                    } else {
                        writeAppointmentToFile();
                    }
                    if (callback != null) {
                        callback.onAppointmentUpdated();
                    }
                    dispose();
                }
            }
        });

        mainPanel.add(bookButton);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private String[] generateCurrentDates() {
        String[] dates = new String[6];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM EEE", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < 6; i++) {
            dates[i] = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to next day
        }

        return dates;
    }

    private class DateButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            selectedDate = source.getText();
            for (JButton button : dateButtons) {
                button.setBackground(Color.decode("#FBFBFB"));  // Reset color of all buttons
            }
            source.setBackground(Color.decode("#005DA4"));  // Set color of selected button
        }
    }

    private class TimeButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            selectedTime = source.getText();
            for (JButton button : timeButtons) {
                button.setBackground(Color.decode("#FBFBFB"));  // Reset color of all buttons
            }
            source.setBackground(Color.decode("#005DA4"));  // Set color of selected button
        }
    }

    private void writeAppointmentToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(hospitalDetails[1] + "," + hospitalDetails[2] + "," + hospitalDetails[7] + "," + hospitalDetails[11] +
                    "," + selectedDate + "," + selectedTime);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateAppointmentInFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            List<String> updatedLines = lines.stream()
                    .map(line -> {
                        String[] details = line.split(",");
                        if (details.length == 6 && details[0].equals(hospitalDetails[1]) && details[4].equals(oldDate) && details[5].equals(oldTime)) {
                            return hospitalDetails[1] + "," + hospitalDetails[2] + "," + hospitalDetails[7] + "," + hospitalDetails[11] +
                                    "," + selectedDate + "," + selectedTime;
                        }
                        return line;
                    })
                    .collect(Collectors.toList());

            Files.write(Paths.get(FILE_PATH), updatedLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




















