package fr.polytech.cours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "finaleval")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalEvalEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "decider", columnDefinition = "varchar(90)")
    private String decider;

    @Column(name = "star", columnDefinition = "INTEGER")
    private Integer star;

    @Column(name = "texte", columnDefinition = "TEXT")
    private String texte;

    @OneToOne()
    @JoinColumn(name = "dernier")
    private RestaurantEntity dernier;

}
