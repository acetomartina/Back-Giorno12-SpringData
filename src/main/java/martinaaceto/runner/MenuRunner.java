package martinaaceto.runner;

import martinaaceto.entities.Drink;
import martinaaceto.entities.Menu;
import martinaaceto.entities.Pizza;
import martinaaceto.entities.Topping;
import martinaaceto.services.DrinkService;
import martinaaceto.services.PizzaService;
import martinaaceto.services.ToppingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {

    private final PizzaService pizzaService;
    private final DrinkService drinkService;
    private final ToppingService toppingService;
    private final Menu menu;

    public MenuRunner(PizzaService pizzaService,
                      DrinkService drinkService,
                      ToppingService toppingService,
                      Menu menu) {

        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
        this.toppingService = toppingService;
        this.menu = menu;
    }

    @Override
    public void run(String... args) {


        // salvo topping

        for (Topping topping : menu.getToppings()) {
            toppingService.saveNewTopping(topping);
        }


        //  salvo bibite

        for (Drink drink : menu.getDrinks()) {
            drinkService.saveNewDrink(drink);
        }


        //  salvo pizze

        for (Pizza pizza : menu.getPizze()) {
            pizzaService.saveNewPizza(pizza);
        }

        System.out.println("\nMenu salvato correttamente nel database!");


        // Query 1

        System.out.println("\nPizze che costano meno di 6€!");

        pizzaService.findByPrezzoMinoreDi(6).forEach(pizza -> {
            System.out.println("Nome: " + pizza.getNome());
            System.out.println("Prezzo: €" + pizza.getPrezzo());
            System.out.println("Calorie: " + pizza.getCalorie());
        });


        // Query 2
        System.out.println("\nPizze con meno di 1150 calorie!");

        pizzaService.findByCalorieMinoriDi(1150).forEach(pizza -> {
            System.out.println("Nome: " + pizza.getNome());
            System.out.println("Prezzo: €" + pizza.getPrezzo());
            System.out.println("Calorie: " + pizza.getCalorie());
        });
    }
}