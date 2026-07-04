package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employment {
    private static final long serialVersionUID = 1L;
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addEmployment" which adds instance of {@linkplain Employment} to extent collection</br>
     * <br>Private Static method "removeEmployment" which removes instance of {@linkplain Employment} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Employment} line by line.</br>
     */
//    @Override
//    public String toString() {
//        return "Employment: " + employmentID + ", id: " + super.toString();
//    }
    private static List<Employment> extent = new ArrayList<>();
    private static void addEmployment(Employment employment) {
        extent.add(employment);
    }
    private static void removeEmployment(Employment employment) {
        extent.remove(employment);
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Employment.class.getName());
        for (Employment employment : extent) {
            System.out.println(employment);
        }
    }
    //EXTENT SESSION END
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "employmentID" typed {@linkplain Integer}
     */
    int employmentID;
    /**Complex, Single, Required, Object, Concrete Attribute "employee" typed {@linkplain Employee}
     */
    private Employee employee;
    /**Complex, Single, Required, Object, Concrete Attribute "startOfWorking" typed {@linkplain LocalDate}
     */
    LocalDate startOfWorking;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Employment(int employmentID, Employee employee, LocalDate startOfWorking) {
        this.employmentID = employmentID;
        this.employee = employee;
        this.startOfWorking = startOfWorking;
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START

    //METHODS SESSION END
    //ASSOCIATION WITH ATTRIBUTE
    private CoffeeHouse coffeeHouse;
    private LocalDate hireDate;
    private String position;
    private float hourlyRate;
    public Employment(Employee employee, CoffeeHouse coffeeHouse,
                      LocalDate hireDate, String position, float hourlyRate) {
        this.employee = employee;
        this.coffeeHouse = coffeeHouse;
        this.hireDate = hireDate;
        this.position = position;
        this.hourlyRate = hourlyRate;
        employee.addEmployment(this);
        coffeeHouse.addEmployment(this);
    }
    public Employee getEmployee() {
        return employee;
    }
    public CoffeeHouse getCoffeeHouse() {
        return coffeeHouse;
    }
    public String toString() {
        return employee.getName() + " works in " +
                coffeeHouse.getCoffeeHouseName() +
                " as " + position +
                " since " + hireDate;
    }
}