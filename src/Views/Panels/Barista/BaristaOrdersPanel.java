package Views.Panels.Barista;

import Models.Barista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BaristaOrdersPanel extends JPanel {

    private final Barista loggedBarista;

    private JTable ordersTable;

    private DefaultTableModel tableModel;

    private JButton refreshButton;

    private JButton prepareButton;

    private JButton detailsButton;

    public BaristaOrdersPanel(Barista loggedBarista) {

        this.loggedBarista = loggedBarista;

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
                "Products",
                "Status"

        });

        ordersTable = new JTable(tableModel);

        ordersTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        refreshButton = new JButton("Refresh");

        prepareButton = new JButton("Prepare Order");

        detailsButton = new JButton("Details");

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Orders Waiting For Preparation",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        add(new JScrollPane(ordersTable),
                BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        bottomPanel.add(refreshButton);

        bottomPanel.add(detailsButton);

        bottomPanel.add(prepareButton);

        add(bottomPanel,
                BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(
                e -> refreshTable()
        );

        detailsButton.addActionListener(
                e -> showDetails()
        );

        prepareButton.addActionListener(
                e -> prepareOrder()
        );

    }

    //=================================================
    // TABLE
    //=================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        /*
            Docelowo:

            for(Order order : Order.getExtent())

            if(order.getStatus()==WAITING)
        */

        tableModel.addRow(new Object[]{

                1,

                "Jan Kowalski",

                "Latte x2",

                "Waiting"

        });

        tableModel.addRow(new Object[]{

                2,

                "Anna Nowak",

                "Espresso",

                "Waiting"

        });

        tableModel.addRow(new Object[]{

                3,

                "Piotr Wiśniewski",

                "Cappuccino",

                "Preparing"

        });

    }

    //=================================================
    // DETAILS
    //=================================================

    private void showDetails() {

        int row = ordersTable.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(

                    this,

                    "Please select an order."

            );

            return;

        }

        JOptionPane.showMessageDialog(

                this,

                "Order ID: " + tableModel.getValueAt(row,0)
                        + "\nClient: " + tableModel.getValueAt(row,1)
                        + "\nProducts: " + tableModel.getValueAt(row,2)
                        + "\nStatus: " + tableModel.getValueAt(row,3)

        );

    }

    //=================================================
    // PREPARE
    //=================================================

    private void prepareOrder() {

        int row = ordersTable.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(

                    this,

                    "Please select an order."

            );

            return;

        }

        tableModel.setValueAt(

                "Ready",

                row,

                3

        );

        JOptionPane.showMessageDialog(

                this,

                "Order is ready to be served."

        );

    }

}