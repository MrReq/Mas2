import Enums.CoffeeCountry;
import Enums.OrderType;
import Enums.Sex;
import Enums.TemperatureOfTheService;
import Models.*;
import SecondaryClasses.ObjectPlus;
import Views.Loging.LoginSelectionView;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectPlus.loadExtents("data/extents.dat");
        } catch (Exception ignored) {
            System.out.println("First application start.");
        }

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    try {
                        ObjectPlus.saveExtents("data/extents.dat");
                        System.out.println("All extents saved.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
        );
        File file = new File("extents.dat");
        try {
            if (file.exists() && file.length() > 0) {
                ObjectPlus.loadExtents("extents.dat");
                System.out.println("Orders: " + Order.getOrderExtent().size());
                System.out.println("Registered classes: " + ObjectPlus.getRegisteredClasses());
                // Jeżeli plik był pusty lub nie zawiera żadnych zamówień
                if (Order.getOrderExtent().isEmpty()) {
                    generateSampleData();
                    ObjectPlus.saveExtents("extents.dat");
                }
            } else {
                generateSampleData();
                ObjectPlus.saveExtents("extents.dat");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() ->
                new LoginSelectionView().setVisible(true)
        );
    }
    private static void generateSampleData() {

        //=================================================
        // CLIENTS
        //=================================================

        Client client1 = new Client(
                "Jan",
                "Kowalski",
                LocalDate.of(1995, 5, 12),
                Sex.Male,true
        );

        Client client2 = new Client(
                "Anna",
                "Nowak",
                LocalDate.of(1998, 8, 20),
                Sex.Female,true
        );

        Client client3 = new Client(
                "Piotr",
                "Wiśniewski",
                LocalDate.of(1992, 2, 18),
                Sex.Male,false
        );

        //=================================================
        // PRODUCTS
        //=================================================

        Product latte = new CafeLatte(
                "Cafe Latte",
                18.50f,
                true,
                "Italian latte",
                TemperatureOfTheService.Hot,
                CoffeeCountry.Kenia
        );

        Product americano = new Americano(
                "Americano",
                15.00f,
                true,
                "Classic americano",
                TemperatureOfTheService.Hot
        );



        //=================================================
        // ORDERS
        //=================================================

        Order order1 =
                Order.createOrder(client1, OrderType.Liquid);

        order1.addProduct(latte);





        Order order2 =
                Order.createOrder(client2, OrderType.Liquid);

        order2.addProduct(americano);


        Order order3 =
                Order.createOrder(client3, OrderType.Liquid);

        order3.addProduct(latte);

        order3.startPreparation();



        Order order4 =
                Order.createOrder(client1, OrderType.Liquid);

        order4.addProduct(americano);

        order4.markAsReady();



        Order order5 =
                Order.createOrder(client2, OrderType.Liquid);

        order5.addProduct(latte);

        order5.cancelOrder();

    }
}