package fr.polytech.cours.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "livres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActeurEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "titre", columnDefinition = "varchar(255)", nullable = false)
    private String titre;

    @ManyToMany
    @JoinTable(name = "biblios_jn_livres",
            joinColumns = @JoinColumn(name = "livre"),
            inverseJoinColumns = @JoinColumn(name = "biblio"))
    private List<SerieEntity> biblios;

    @OneToMany(mappedBy = "livre")
    private List<CommentaireEntity> commentaires;

}
