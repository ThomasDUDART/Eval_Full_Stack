package fr.polytech.cours.service;


import fr.polytech.cours.dto.response.EvalDto;
import fr.polytech.cours.entity.EvalEntity;
import fr.polytech.cours.exception.InvalidValueException;
import fr.polytech.cours.exception.ResourceNotFoundException;
import fr.polytech.cours.repository.EvalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EvalService {

    private final EvalRepository evalRepository;

    private final S3Service s3Service;

    public List<EvalEntity> getEval() {
        return this.evalRepository.findAll();
    }

    public List<EvalEntity> getEval(final List<Integer> idsToFetch) {
        return this.evalRepository.findAllById(idsToFetch);
    }

    public EvalEntity getEvalById(final Integer id) {
        return this.evalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("eval with id " + id + " + not found"));
    }

    public EvalEntity addEval(final EvalDto evalDto) {
        final EvalEntity evalToInsert = EvalEntity.builder().evaluater(evalDto.getEvaluater()).build();

        return this.evalRepository.save(evalToInsert);
    }

    public void deleteEval(final Integer id) {
        this.evalRepository.deleteById(id);
    }

    public EvalEntity updateEval(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final EvalEntity evalToUpdate = this.evalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le eval d'id " + id + " n'existe pas"));
        evalToUpdate.setEvaluater(nouveauNom);
        evalRepository.save(evalToUpdate);
        return evalToUpdate;
    }

    public String getCoverDownloadUrl(final Integer evalId) {
        this.getEvalById(evalId);

        return this.s3Service.getDownloadUrl("ThomasPlat" + evalId);
    }

    public String putCoverDownloadUrl(final Integer evalId) {
        this.getEvalById(evalId);

        return this.s3Service.putDownloadUrl("ThomasPlat" + evalId);
    }

}
