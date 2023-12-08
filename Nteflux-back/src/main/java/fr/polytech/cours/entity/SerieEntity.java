package fr.polytech.cours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "biblios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SerieEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(255)", nullable = false)
    private String nom;

    @ManyToMany(mappedBy = "biblios")
    private List<ActeurEntity> livres;

}
