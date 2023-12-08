package fr.polytech.cours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "restau")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(90)", nullable = false)
    private String nom;

    @Column(name = "adresse", columnDefinition = "varchar(255)", nullable = false)
    private String adresse;

    @OneToMany(mappedBy = "eval")
    private List<EvalEntity> eval;

    @OneToOne(mappedBy = "dernier")
    private FinalEvalEntity dernier;

}
