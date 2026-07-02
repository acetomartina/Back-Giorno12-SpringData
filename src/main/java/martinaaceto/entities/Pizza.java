package martinaaceto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pizze")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "toppings")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double prezzo;

    @Column(nullable = false)
    private int calorie;

    // una pizza può avere più topping e lo stesso topping può essere su più pizze
    // quindi ManyToMany
    // Hibernate creerà in automatico tre tabelle (pizze, topping e pizza_toppings che sarà quella di collegamento
    @ManyToMany
    @JoinTable(
            name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}