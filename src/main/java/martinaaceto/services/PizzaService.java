package martinaaceto.services;

import martinaaceto.entities.Pizza;
import martinaaceto.repositories.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza saveNewPizza(Pizza pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public List<Pizza> findAll() {
        return this.pizzaRepository.findAll();
    }
}