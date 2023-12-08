package fr.polytech.cours.controller;

import fr.polytech.cours.dto.request.AddSerieDto;
import fr.polytech.cours.dto.response.SerieDto;
import fr.polytech.cours.service.SerieService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/biblios")
    public List<SerieDto> getBiblios() {
        return this.serieService.getAllBiblios();
    }

    @PostMapping("/biblios")
    public SerieDto addBibliotheque(@Valid @RequestBody AddSerieDto biblioToCreate) {
        return this.serieService.addBiblio(biblioToCreate);
    }

}
