package Models;
import Enums.Sex;
import Interfaces.IClient;
import SecondaryClasses.ObjectPlus;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
public class WorkingClient extends Employee implements IClient {
    private static final long serialVersionUID = 1L;
    public static List<WorkingClient> getWorkingClientExtent() {
        return ObjectPlus.getExtent(WorkingClient.class);
    }
    Client client;
    public WorkingClient(String firstName, String lastName, LocalDate birthDate, Sex sex, float salary, boolean hasClubCard) {
        super(firstName, lastName, birthDate, sex,  salary);
        client = new Client(null,null,null,null,hasClubCard);
    }
    @Override
    public String toString() {
        return "I am the Working client";
    }
    @Override
    public int getTable() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
    @Override
    public String getCoffee() {
        return "I'm getting a coffee";
    }
    @Override
    public void GiveSatisfactionLevel() {
        System.out.println("I am giving the rate");
    }
}
