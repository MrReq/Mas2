package Views.Panels.Waiter;

import Models.Waiter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WaiterOrdersPanel extends JPanel {

    private final Waiter waiter;

    private JTable ordersTable;

    private DefaultTableModel tableModel;

    private JButton refreshButton;

    private JButton serveButton;

    private JButton detailsButton;

    public WaiterOrdersPanel(Waiter waiter) {

        this.waiter = waiter;

        initializeComponents();

        initializeLayout();

        initializeListeners();

        refreshTable();

    }

    //=================================================
    // COMPONENTS
    //=================================================

    private void initializeComponents() {

        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{

                "Order ID",
                "Client",
                "Table",
                "Status",
                "Value"

        });

        ordersTable = new JTable(tableModel);

        ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        refreshButton = new JButton("Refresh");

        serveButton = new JButton("Serve Order");

        detailsButton = new JButton("Details");

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        add(new JScrollPane(ordersTable), BorderLayout.CENTER);

        JPanel bottom = new JPanel();

        bottom.add(refreshButton);

        bottom.add(detailsButton);

        bottom.add(serveButton);

        add(bottom, BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(e -> refreshTable());

        detailsButton.addActionListener(e -> showDetails());

        serveButton.addActionListener(e -> serveOrder());

    }

    //=================================================
    // TABLE
    //=================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        tableModel.addRow(new Object[]{
                1,
                "John Smith",
                3,
                "READY",
                42.50
        });

        tableModel.addRow(new Object[]{
                2,
                "Anna Brown",
                6,
                "WAITING",
                18.00
        });

    }

    //=================================================
    // DETAILS
    //=================================================

    private void showDetails() {

        int row = ordersTable.getSelectedRow();

        if(row==-1){

            JOptionPane.showMessageDialog(this,"Select order.");

            return;

        }

        JOptionPane.showMessageDialog(

                this,

                "Order ID: "
                        + tableModel.getValueAt(row,0)
                        + "\nClient: "
                        + tableModel.getValueAt(row,1)

        );

    }

    //=================================================
    // SERVE
    //=================================================

    private void serveOrder() {

        int row = ordersTable.getSelectedRow();

        if(row==-1){

            JOptionPane.showMessageDialog(this,"Select order.");

            return;

        }

        tableModel.setValueAt(

                "SERVED",

                row,

                3

        );

        JOptionPane.showMessageDialog(

                this,

                "Order served."

        );

    }

}