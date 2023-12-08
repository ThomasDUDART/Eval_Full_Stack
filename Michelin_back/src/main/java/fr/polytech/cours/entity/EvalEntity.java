package fr.polytech.cours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity(name = "eval")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvalEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "evaluater", columnDefinition = "varchar(50)", nullable = false)
    private String evaluater;

    @Column(name = "comment", columnDefinition = "varchar(255)", nullable = false)
    private String comment;

    @Column(name = "star", columnDefinition = "INTEGER", nullable = false)
    private Integer star;

    @Column(name = "datecreation", columnDefinition = "DATE", nullable = false)//saisie manuel date de création, pas optimale mais pas le temps et l'aisance de faire mieux en contrôlle
    private final Date datecreation = new Date();//s'actualise qu'a la création comme final

    @Temporal(TemporalType.TIMESTAMP) //Création auto à la modification/création
    public Date updateDate = new Date();

    @ManyToOne
    @JoinColumn(name = "eval")
    private RestaurantEntity eval;

}
