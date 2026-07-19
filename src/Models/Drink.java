package Models;
import Enums.Size;
import Enums.TemperatureOfTheService;
import Interfaces.Preparable;
import SecondaryClasses.ObjectPlus;

import java.util.List;

public class Drink extends Product implements Preparable {
    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "Drink: " + super.productName  + super.toString()+" " + coffeineContain + " " + size;
    }
    public static List<Drink> getDrinkExtent() {
        return ObjectPlus.getExtent(Drink.class);
    }
    boolean coffeineContain;
    Size size;
    public Drink(String name, float cost, boolean availability, String description, TemperatureOfTheService temperatureOfService) {
        super(name, cost, availability, description, temperatureOfService);
    }
    public Drink(String name, float cost, boolean availability, String description, TemperatureOfTheService temperatureOfService, boolean coffeineContain, Size size) {
        super(name, cost, availability, description, temperatureOfService);
        this.coffeineContain = coffeineContain;
        this.size = size;
    }
    public Drink() {
        super();
    }
    @Override
    public void prepare() {
    }
    @Override
    public int getPreparationTime() {
        return 0;
    }
}