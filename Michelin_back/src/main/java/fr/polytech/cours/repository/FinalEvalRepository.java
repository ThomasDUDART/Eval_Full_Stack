package fr.polytech.cours.repository;

import fr.polytech.cours.entity.FinalEvalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalEvalRepository extends JpaRepository<FinalEvalEntity, Integer> {
}
