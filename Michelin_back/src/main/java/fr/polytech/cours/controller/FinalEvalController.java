package fr.polytech.cours.controller;

import fr.polytech.cours.dto.request.AddFinalEvalDto;
import fr.polytech.cours.dto.response.FinalEvalDto;
import fr.polytech.cours.service.FinalEvalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class FinalEvalController {

    private final FinalEvalService finalEvalService;

    @PostMapping("/livres/{livreId}/finalEval")
    public FinalEvalDto addFinalEval(@PathVariable Integer livreId, @Valid @RequestBody AddFinalEvalDto addFinalEvalDto) {
        return FinalEvalDto.buildFromEntity(this.finalEvalService.addFinalEvalToRestau(livreId, addFinalEvalDto));
    }

}
