package Views.Boss;
import Models.Boss;
import Views.Loging.LoginSelectionView;
import javax.swing.*;
import java.awt.*;
public class BossDashboardView extends JFrame {
    private final JTabbedPane tabbedPane;
    private final Boss loggedBoss;
    private BossProductsPanel productsPanel;
    private ManageEmployeesView employeesPanel;
    public BossDashboardView(Boss loggedBoss) {
        this.loggedBoss = loggedBoss;
        productsPanel = new BossProductsPanel(loggedBoss);
        employeesPanel = new ManageEmployeesView(loggedBoss);
        setTitle("Coffee House Management System - Owner Panel (BossDashboardView)");
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Products", productsPanel);
        tabbedPane.addTab("Employees", employeesPanel);
        setLayout(new BorderLayout());
        add(createTopPanel(), BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }
    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Coffee House - Owner Dashboard (BossDashBoardView)");
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
    public void refreshTables() {
        productsPanel.refreshTable();
        employeesPanel.refreshTable();
    }
}
