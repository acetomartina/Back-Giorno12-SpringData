package martinaaceto.config;

import martinaaceto.entities.Drink;
import martinaaceto.entities.Menu;
import martinaaceto.entities.Pizza;
import martinaaceto.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MenuConfig {

    // topping

    @Bean
    public Topping pomodoro() {
        return new Topping("Pomodoro", 0.00, 0);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 0.80, 92);
    }

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.00, 35);
    }

    @Bean
    public Topping funghi() {
        return new Topping("Funghi", 0.80, 22);
    }

    // pizze

    @Bean
    public Pizza pizzaMargherita() {
        Pizza pizza = new Pizza("Margherita", 4.99, 1104);
        pizza.setToppings(List.of(pomodoro(), mozzarella()));
        return pizza;
    }

    @Bean
    public Pizza pizzaProsciutto() {
        Pizza pizza = new Pizza("Pizza Prosciutto", 5.99, 1160);
        pizza.setToppings(List.of(pomodoro(), mozzarella(), prosciutto()));
        return pizza;
    }

    @Bean
    public Pizza pizzaFunghi() {
        Pizza pizza = new Pizza("Pizza ai Funghi", 5.99, 1150);
        pizza.setToppings(List.of(pomodoro(), mozzarella(), funghi()));
        return pizza;
    }

    // BIBITE

    @Bean
    public Drink limonata() {
        return new Drink("Limonata", 1.29, 128);
    }

    @Bean
    public Drink acqua() {
        return new Drink("Acqua", 1.29, 0);
    }

    @Bean
    public Drink vino() {
        return new Drink("Vino", 7.49, 607);
    }

    // menu

    @Bean
    public Menu menu() {
        return new Menu(
                List.of(pizzaMargherita(), pizzaProsciutto(), pizzaFunghi()),
                List.of(limonata(), acqua(), vino()),
                List.of(pomodoro(), mozzarella(), prosciutto(), funghi())
        );
    }
}