package fr.polytech.cours.service;

import fr.polytech.cours.dto.request.AddCommentaireDto;
import fr.polytech.cours.entity.CommentaireEntity;
import fr.polytech.cours.entity.ActeurEntity;
import fr.polytech.cours.repository.CommentaireRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;
    private final ActeurService acteurService;

    public CommentaireEntity addCommentaireToLivre(final Integer livreId, final AddCommentaireDto dto) {
        final ActeurEntity livre = this.acteurService.getLivreById(livreId);

        final CommentaireEntity commentaire = CommentaireEntity.builder().texte(dto.getTexte()).livre(livre).build();

        return this.commentaireRepository.save(commentaire);
    }

}
