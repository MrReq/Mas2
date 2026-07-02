package Views.Panels.Barista;

import Models.Barista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BaristaPrepareCoffeePanel extends JPanel {

    private final Barista loggedBarista;

    private JTable coffeeTable;

    private DefaultTableModel tableModel;

    private JButton refreshButton;

    private JButton startPreparationButton;

    private JButton finishPreparationButton;

    public BaristaPrepareCoffeePanel(Barista loggedBarista) {

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
                "Coffee",
                "Quantity",
                "Temperature",
                "Status"

        });

        coffeeTable = new JTable(tableModel);

        coffeeTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        refreshButton = new JButton("Refresh");

        startPreparationButton =
                new JButton("Start preparation");

        finishPreparationButton =
                new JButton("Coffee ready");

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Coffee Preparation",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        add(title, BorderLayout.NORTH);

        add(new JScrollPane(coffeeTable),
                BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        bottomPanel.add(refreshButton);

        bottomPanel.add(startPreparationButton);

        bottomPanel.add(finishPreparationButton);

        add(bottomPanel, BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(
                e -> refreshTable()
        );

        startPreparationButton.addActionListener(
                e -> startPreparation()
        );

        finishPreparationButton.addActionListener(
                e -> finishPreparation()
        );

    }

    //=================================================
    // TABLE
    //=================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        /*
         Docelowo:

         for(Order order : Order.getExtent()) {

             if(order.getStatus()==WAITING_FOR_PREPARATION){

                 ...
             }

         }
        */

        tableModel.addRow(new Object[]{

                1,

                "Cappuccino",

                2,

                "Hot",

                "Waiting"

        });

        tableModel.addRow(new Object[]{

                2,

                "Espresso",

                1,

                "Hot",

                "Preparing"

        });

        tableModel.addRow(new Object[]{

                3,

                "Iced Latte",

                1,

                "Cold",

                "Waiting"

        });

    }

    //=================================================
    // START PREPARATION
    //=================================================

    private void startPreparation() {

        int row = coffeeTable.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(

                    this,

                    "Please select coffee."

            );

            return;

        }

        tableModel.setValueAt(

                "Preparing",

                row,

                4

        );

        JOptionPane.showMessageDialog(

                this,

                "Coffee preparation started."

        );

    }

    //=================================================
    // FINISH PREPARATION
    //=================================================

    private void finishPreparation() {

        int row = coffeeTable.getSelectedRow();

        if(row == -1){

            JOptionPane.showMessageDialog(

                    this,

                    "Please select coffee."

            );

            return;

        }

        tableModel.setValueAt(

                "Ready",

                row,

                4

        );

        JOptionPane.showMessageDialog(

                this,

                "Coffee is ready to serve."

        );

    }

}