package fr.polytech.cours.controller;

import fr.polytech.cours.dto.request.AddActeurDto;
import fr.polytech.cours.dto.response.ActeurDto;
import fr.polytech.cours.dto.response.UrlDto;
import fr.polytech.cours.service.ActeurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class ActeurController {

    private final ActeurService acteurService;

    @GetMapping("/livres")
    public List<ActeurDto> getLivres(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.acteurService.getLivres().stream().map(livreEntity -> ActeurDto.buildFromEntity(livreEntity)).toList();
        } else {
            return this.acteurService.getLivres(idsToFetch).stream().map(livreEntity -> ActeurDto.buildFromEntity(livreEntity)).toList();
        }
    }

    @GetMapping("/livres/{id}")
    public ActeurDto getLivreById(@PathVariable Integer id) {
        return ActeurDto.buildFromEntity(this.acteurService.getLivreById(id));
    }

    @GetMapping("/livres/{id}/cover")
    public UrlDto getLivreCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.acteurService.getCoverDownloadUrl(id)).build();
    }

    @PutMapping("/livres/{id}/cover")
    public UrlDto putLivreCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.acteurService.putCoverDownloadUrl(id)).build();
    }

    @PostMapping("/livres")
    public ActeurDto addLivre(@Valid @RequestBody AddActeurDto livreDto) {
        return ActeurDto.buildFromEntity(this.acteurService.addLivre(livreDto));
    }

    @DeleteMapping("/livres/{id}")
    public void deleteLivre(@PathVariable Integer id) {
        this.acteurService.deleteLivre(id);
    }

}
