package cs342project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bill extends JFrame {
    public Bill(int bookingID, String carName, String startDate, String endDate, double totalPrice) {
        setTitle("Booking Invoice");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setEnabled(false); 
        tableModel.addColumn("Field");
        tableModel.addColumn("Details");

        tableModel.addRow(new Object[]{"Booking ID", bookingID});
        tableModel.addRow(new Object[]{"Car Name", carName});
        tableModel.addRow(new Object[]{"Start Date", startDate});
        tableModel.addRow(new Object[]{"End Date", endDate});
        tableModel.addRow(new Object[]{"Total Price", "$" + String.format("%.2f", totalPrice)});

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

   
  
}
