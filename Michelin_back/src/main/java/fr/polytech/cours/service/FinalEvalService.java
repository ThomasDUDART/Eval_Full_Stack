package fr.polytech.cours.service;


import fr.polytech.cours.dto.request.AddFinalEvalDto;
import fr.polytech.cours.entity.FinalEvalEntity;
import fr.polytech.cours.entity.RestaurantEntity;
import fr.polytech.cours.repository.FinalEvalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FinalEvalService {

    private final RestaurantService restaurantService;

    private final FinalEvalRepository finalEvalRepository;

    public FinalEvalEntity addFinalEvalToRestau(final Integer restauId, final AddFinalEvalDto dto) {
        final RestaurantEntity restau = this.restaurantService.getRestauById(restauId);

        final FinalEvalEntity commentaire = FinalEvalEntity.builder().texte(dto.getTexte()).dernier(restau).build();

        return this.finalEvalRepository.save(commentaire);
    }

}
