package Views.Panels.Barista;

import Models.Barista;

import javax.swing.*;
import java.awt.*;

public class BaristaStatisticsPanel extends JPanel {

    private final Barista loggedBarista;

    private JLabel preparedCoffeeLabel;
    private JLabel waitingOrdersLabel;
    private JLabel completedOrdersLabel;
    private JLabel workedHoursLabel;
    private JLabel favouriteCoffeeCountryLabel;

    private JButton refreshButton;

    public BaristaStatisticsPanel(Barista loggedBarista) {

        this.loggedBarista = loggedBarista;

        initializeComponents();

        initializeLayout();

        initializeListeners();

        refreshStatistics();

    }

    //=================================================
    // COMPONENTS
    //=================================================

    private void initializeComponents() {

        preparedCoffeeLabel = new JLabel();

        waitingOrdersLabel = new JLabel();

        completedOrdersLabel = new JLabel();

        workedHoursLabel = new JLabel();

        favouriteCoffeeCountryLabel = new JLabel();

        refreshButton = new JButton("Refresh");

    }

    //=================================================
    // LAYOUT
    //=================================================

    private void initializeLayout() {

        setLayout(new BorderLayout());

        JLabel title = new JLabel(
                "Barista Statistics",
                SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 24));

        add(title, BorderLayout.NORTH);

        JPanel statisticsPanel = new JPanel();

        statisticsPanel.setLayout(new GridLayout(6,2,10,10));

        statisticsPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        30,
                        50,
                        30,
                        50
                )
        );

        statisticsPanel.add(new JLabel("Barista:"));

        statisticsPanel.add(new JLabel(
                loggedBarista.getPersonName()
                        + " "
                        + loggedBarista.getPeronSurname()
        ));

        statisticsPanel.add(new JLabel("Prepared coffees:"));

        statisticsPanel.add(preparedCoffeeLabel);

        statisticsPanel.add(new JLabel("Waiting orders:"));

        statisticsPanel.add(waitingOrdersLabel);

        statisticsPanel.add(new JLabel("Completed orders:"));

        statisticsPanel.add(completedOrdersLabel);

        statisticsPanel.add(new JLabel("Worked hours:"));

        statisticsPanel.add(workedHoursLabel);

        statisticsPanel.add(new JLabel("Favourite coffee country:"));

        statisticsPanel.add(favouriteCoffeeCountryLabel);

        add(statisticsPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();

        bottomPanel.add(refreshButton);

        add(bottomPanel, BorderLayout.SOUTH);

    }

    //=================================================
    // LISTENERS
    //=================================================

    private void initializeListeners() {

        refreshButton.addActionListener(
                e -> refreshStatistics()
        );

    }

    //=================================================
    // REFRESH
    //=================================================

    private void refreshStatistics() {

        /*
         Docelowo dane będą pobierane z modelu.
         */

        preparedCoffeeLabel.setText("158");

        waitingOrdersLabel.setText("4");

        completedOrdersLabel.setText("154");

        workedHoursLabel.setText("172 h");

        if(loggedBarista.getFavouriteCoffeeCountry() != null){

            favouriteCoffeeCountryLabel.setText(
                    loggedBarista.getFavouriteCoffeeCountry().name()
            );

        }else{

            favouriteCoffeeCountryLabel.setText("Not specified");

        }

    }

}