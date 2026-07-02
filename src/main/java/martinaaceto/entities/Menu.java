package martinaaceto.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

// menu non sarà salvato nel DB perché è solo un contenitore di drink, pizza e topping
// quindi rimane un bean
// una pizza, un drink o un topping esistono anche senza il menu, quindi non è una @Entity
@Getter
@Setter
@ToString
public class Menu {

    private List<Pizza> pizze;
    private List<Drink> drinks;
    private List<Topping> toppings;

    public Menu(List<Pizza> pizze, List<Drink> drinks, List<Topping> toppings) {
        this.pizze = pizze;
        this.drinks = drinks;
        this.toppings = toppings;
    }
}