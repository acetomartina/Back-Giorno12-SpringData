package martinaaceto.services;

import martinaaceto.entities.Drink;
import martinaaceto.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink saveNewDrink(Drink drink) {
        return this.drinkRepository.save(drink);
    }

    public List<Drink> findAll() {
        return this.drinkRepository.findAll();
    }
}