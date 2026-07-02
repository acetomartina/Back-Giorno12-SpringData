package martinaaceto.services;

import martinaaceto.entities.Topping;
import martinaaceto.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {

    private final ToppingRepository toppingRepository;

    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    public Topping saveNewTopping(Topping topping) {
        return this.toppingRepository.save(topping);
    }

    public List<Topping> findAll() {
        return this.toppingRepository.findAll();
    }
}