package fr.polytech.cours.repository;

import fr.polytech.cours.entity.ActeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<ActeurEntity, Integer> {
}
