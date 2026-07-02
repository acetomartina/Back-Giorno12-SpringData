package martinaaceto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double prezzo;

    @Column(nullable = false)
    private int calorie;

    public Drink(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}