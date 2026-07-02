package Views.Employee;
import Models.Waiter;
import Views.Loging.LoginSelectionView;
import Views.Panels.Waiter.WaiterOrdersPanel;
import Views.Panels.Waiter.WaiterPaymentsPanel;
import Views.Panels.Waiter.WaiterStatisticsPanel;
import Views.Panels.Waiter.WaiterTablesPanel;

import javax.swing.*;
import java.awt.*;

public class WaiterDashboardView extends JFrame {

    private final Waiter loggedWaiter;

    private JTabbedPane tabbedPane;

    public WaiterDashboardView(Waiter waiter) {

        this.loggedWaiter = waiter;

        initializeFrame();

        initializeComponents();

        initializeLayout();

    }

    //=================================================
    // FRAME
    //=================================================

    private void initializeFrame() {

        setTitle("Coffee House Management System - Waiter");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //=================================================
    // COMPONENTS
    //=================================================

    private void initializeComponents() {

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab(
                "Orders",
                new WaiterOrdersPanel(loggedWaiter)
        );

        tabbedPane.addTab(
                "Tables",
                new WaiterTablesPanel(loggedWaiter)
        );

        tabbedPane.addTab(
                "Payments",
                new WaiterPaymentsPanel(loggedWaiter)
        );

        tabbedPane.addTab(
                "Statistics",
                new WaiterStatisticsPanel(loggedWaiter)
        );

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);

        add(tabbedPane, BorderLayout.CENTER);

    }

    //=================================================
    // TOP PANEL
    //=================================================

    private JPanel createTopPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        JLabel title = new JLabel(

                "Logged as: "
                        + loggedWaiter.getPersonName()
                        + " "
                        + loggedWaiter.getPeronSurname()

        );

        title.setFont(new Font("Arial", Font.BOLD, 22));

        JButton logoutButton = new JButton("Logout");

        logoutButton.addActionListener(e -> {

            dispose();

            new LoginSelectionView().setVisible(true);

        });

        panel.add(title, BorderLayout.WEST);

        panel.add(logoutButton, BorderLayout.EAST);

        return panel;

    }

}
