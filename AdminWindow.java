package cs342project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class AdminWindow extends JFrame {
    private JButton Modification, History, LogOut;
    private JTable carTable, returnedCarsTable;
    private JLabel Cars, AdminWindow;
    private DefaultTableModel carTableModel, returnedCarsTableModel;

    public AdminWindow1() {
        setTitle("Admin Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Modification = new JButton("Modification On Cars");
        History = new JButton("View Rental History");
        LogOut = new JButton("Log Out");

        JButton[] buttons = {Modification, History, LogOut};
        Font buttonFont = new Font("Serif", Font.BOLD, 14);
        Color buttonColor = new Color(100, 149, 200);
        Color buttonTextColor = Color.WHITE;
        for (JButton button : buttons) {
            button.setFont(buttonFont);
            button.setPreferredSize(new Dimension(200, 35));
            button.setBackground(buttonColor);
            button.setForeground(buttonTextColor);
        }

        carTableModel = new DefaultTableModel(new Object[]{"Make", "Model", "Year", "Type", "Color","Status", "Price/Day"}, 0);
        carTable = new JTable(carTableModel);
        JScrollPane carsScrollPane = new JScrollPane(carTable);
        carsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        carsScrollPane.setPreferredSize(new Dimension(500, 150));

      
        returnedCarsTableModel = new DefaultTableModel(new Object[]{"Booking ID", "User Id", "Vehicle Id","Start Date","End Date","Status","Total Price"}, 0);
        returnedCarsTable = new JTable(returnedCarsTableModel);
        JScrollPane returnedCarsScrollPane = new JScrollPane(returnedCarsTable);
        returnedCarsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        returnedCarsScrollPane.setPreferredSize(new Dimension(500, 150));

        AdminWindow = new JLabel("Admin Window", SwingConstants.CENTER);
        AdminWindow.setFont(new Font("Serif", Font.BOLD, 24));
        AdminWindow.setForeground(Color.BLACK);

        JPanel carsPanel = new JPanel(new BorderLayout());
        carsPanel.add(new JLabel("All Cars", SwingConstants.CENTER), BorderLayout.NORTH);
        carsPanel.add(carsScrollPane, BorderLayout.CENTER);

        JPanel returnedCarsPanel = new JPanel(new BorderLayout());
        returnedCarsPanel.add(new JLabel("Returned Cars", SwingConstants.CENTER), BorderLayout.NORTH);
        returnedCarsPanel.add(returnedCarsScrollPane, BorderLayout.CENTER);

        JPanel tablesPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        tablesPanel.add(carsPanel);
        tablesPanel.add(returnedCarsPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(Modification);
        buttonPanel.add(History);
        buttonPanel.add(LogOut);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(AdminWindow, BorderLayout.NORTH);
        mainPanel.add(tablesPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);

        setVisible(true);

 
        LogOut.addActionListener(new LogOut());
        History.addActionListener(new History());
        Modification.addActionListener(new modi());
       
        loadCarsFromDatabase();
        loadReturnedCarsFromDatabase();
    }

    private void loadCarsFromDatabase() {
        try (Connection connection = DatabaseConnection.connect();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Vehicles")) {

           
            carTableModel.setRowCount(0);

            while (rs.next()) {
                carTableModel.addRow(new Object[]{
                        rs.getString("Make"),
                        rs.getString("Model"),
                        rs.getString("Year"),
                        rs.getString("Type"),
                        rs.getString("Color"),
                        rs.getString("Status"),
                        rs.getDouble("PricePerDay"),
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading cars: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadReturnedCarsFromDatabase() {
        try (Connection connection = DatabaseConnection.connect()) {

            returnedCarsTableModel.setRowCount(0);
            String query = "SELECT * FROM Bookings WHERE LOWER(Status) = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, "completed"); // تعيين القيمة المراد البحث عنها
            ResultSet rs = stmt.executeQuery();
            // إضافة البيانات من قاعدة البيانات إلى الجدول
            while (rs.next()) {
                returnedCarsTableModel.addRow(new Object[]{
                        rs.getString("BookingID"),
                        rs.getString("UserID"),
                        rs.getString("VehicleID"),
                        rs.getString("StartDate"),
                        rs.getString("EndDate"),
                        rs.getString("Status"),
                        rs.getDouble("TotalPrice"),
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading returned cars: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public class LogOut implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FirstPage Out = new FirstPage();
            Out.setVisible(true);
            dispose();
        }
    }

    public class modi implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ModificationOnCars add = new ModificationOnCars();
            add.setVisible(true);
            dispose();
        }
    }

    public class History implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CarRentalHistory add = new CarRentalHistory();
            add.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new AdminWindow1();
    }
}
