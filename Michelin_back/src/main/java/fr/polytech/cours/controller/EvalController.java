package fr.polytech.cours.controller;

import fr.polytech.cours.dto.response.EvalDto;
import fr.polytech.cours.dto.response.UrlDto;
import fr.polytech.cours.service.EvalService;
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
public class EvalController {

    private final EvalService evalService;

    @GetMapping("/Eval")
    public List<EvalDto> getEval(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.evalService.getEval().stream().map(evalEntity -> EvalDto.buildFromEntity(evalEntity)).toList();
        } else {
            return this.evalService.getEval(idsToFetch).stream().map(evalEntity -> EvalDto.buildFromEntity(evalEntity)).toList();
        }
    }

    @GetMapping("/Eval/{id}")
    public EvalDto getEvalById(@PathVariable Integer id) {
        return EvalDto.buildFromEntity(this.evalService.getEvalById(id));
    }

    @GetMapping("/Eval/{id}/cover")
    public UrlDto getEvalCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.evalService.getCoverDownloadUrl(id)).build();
    }

    @PutMapping("/Eval/{id}/cover")
    public UrlDto putEvalCoverById(@PathVariable Integer id) {
        return UrlDto.builder().url(this.evalService.putCoverDownloadUrl(id)).build();
    }

    @PostMapping("/Eval")
    public EvalDto addEval(@Valid @RequestBody EvalDto evalDto) {
        return EvalDto.buildFromEntity(this.evalService.addEval(evalDto));
    }

    @DeleteMapping("/Eval/{id}")
    public void deleteEval(@PathVariable Integer id) {
        this.evalService.deleteEval(id);
    }

}
