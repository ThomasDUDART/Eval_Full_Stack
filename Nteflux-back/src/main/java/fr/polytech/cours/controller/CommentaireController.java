package fr.polytech.cours.controller;

import fr.polytech.cours.dto.request.AddCommentaireDto;
import fr.polytech.cours.dto.response.CommentaireDto;
import fr.polytech.cours.service.CommentaireService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class CommentaireController {

    private final CommentaireService commentaireService;

    @PostMapping("/livres/{livreId}/commentaires")
    public CommentaireDto addCommentaire(@PathVariable Integer livreId, @Valid @RequestBody AddCommentaireDto addCommentaireDto) {
        return CommentaireDto.buildFromEntity(this.commentaireService.addCommentaireToLivre(livreId, addCommentaireDto));
    }

}
