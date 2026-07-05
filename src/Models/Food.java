package Models;

import java.util.ArrayList;
import java.util.List;

import Enums.Doneness;
import Enums.TemperatureOfTheService;
import Enums.TypeOfMeal;
import SecondaryClasses.ObjectPlus;

public class Food extends Product {
    private static final long serialVersionUID = 1L;
    //EXTENT SESSION
    /** Extent session contains:
     * <br>to String method</br>
     * <br>{@linkplain List} in implementation as {@linkplain ArrayList} called extent that holds all instances</br>
     * <br>Private Static method "addFood" which adds instance of {@linkplain Food} to extent collection</br>
     * <br>Private Static method "removeFood" which removes instance of {@linkplain Food} from extent collection</br>
     * <br>Public Static method "showExtent" which displays all instances of {@linkplain Food} line by line.</br>
     */
    @Override
    public String toString() {
        return "Food: " + productName + " " + super.toString() +" "+ weight + " " + typeOfMeal + " " + doneness;
    }

    @SuppressWarnings("unchecked")
    public static List<Food> getFoodExtent() {
        return (List<Food>) (List<?>) ObjectPlus.getExtent(Food.class);
    }
    //FIELDS SESSION START
    /**Simple, Single, Required, Object, Concrete Attribute "weight" typed {@linkplain Double}
     */
    double weight;
    /**Simple, Single, Required, Object, Concrete Attribute "typeOfMeal" typed {@linkplain TypeOfMeal}
     */
    TypeOfMeal typeOfMeal;
    /**Simple, Single, Required, Object, Concrete Attribute "doneness" typed {@linkplain Doneness}
     */
    Doneness doneness;
    //FIELDS SESSION END
    //CONSTRUCTORS, GETTERS, SETTERS SESSION START
    public Food(String name, float cost, boolean availability, String description, TemperatureOfTheService temperatureOfService) {
        super(name, cost, availability, description, temperatureOfService);
    }
    public Food(String name, float cost, boolean availability, String description, TemperatureOfTheService temperatureOfService, double weight, TypeOfMeal typeOfMeal, Doneness doneness) {
        super(name, cost, availability, description, temperatureOfService);
        this.weight = weight;
        this.typeOfMeal = typeOfMeal;
        this.doneness = doneness;
    }
    //CONSTRUCTORS, GETTERS, SETTERS SESSION END
    //METHODS SESSION START
    @Override
    public void prepare() {

    }
    @Override
    public int getPreparationTime() {
        return 0;
    }
    //METHODS SESSION END
}
