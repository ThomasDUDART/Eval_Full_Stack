package fr.polytech.cours.repository;

import fr.polytech.cours.entity.EvalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvalRepository extends JpaRepository<EvalEntity, Integer> {
}
