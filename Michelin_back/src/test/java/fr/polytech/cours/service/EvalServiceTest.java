package fr.polytech.cours.service;

import fr.polytech.cours.dto.response.EvalDto;
import fr.polytech.cours.entity.EvalEntity;
import fr.polytech.cours.exception.InvalidValueException;
import fr.polytech.cours.exception.ResourceNotFoundException;
import fr.polytech.cours.repository.EvalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EvalServiceTest {

    @Mock
    private EvalRepository evalRepository;

    @InjectMocks
    private EvalService evalService;
    private S3Service s3Service;
    private EvalDto evalDto;


    @Test
    public void update_eval_with_null_evaluater() {
        assertThrows(InvalidValueException.class, () -> this.evalService.updateEval(0, null));
    }

    @Test
    public void update_eval_with_non_existing_evaluater() {
        assertThrows(ResourceNotFoundException.class, () -> this.evalService.updateEval(0, "jean"));
    }

    @Test
    public void update_eval_ok() {
        when(this.evalRepository.findById(anyInt())).thenReturn(Optional.of(EvalEntity.builder().build()));
        final EvalEntity result = this.evalService.updateEval(123, "jean");

        assertEquals("jean", result.getEvaluater());
    }

    @Test
    public void add_eval_ok() {
        final EvalEntity result = this.evalService.addEval(evalDto.builder().evaluater("jean").build());

        assertEquals("jean", result.getEvaluater()); //test passe pas normal mon add fonctionne pas
    }

    @Test
    public void add_eval_non_ok() {
        final EvalEntity result = this.evalService.addEval(evalDto.builder().evaluater("jean").build());

        assertNotEquals("jean", result.getEvaluater()); //test passe pas normal mon add fonctionne pas
    }

    @Test
    public void Get_eval_by_id_ok() {
        when(this.evalRepository.findById(anyInt())).thenReturn(Optional.of(EvalEntity.builder().build()));
        final EvalEntity result = this.evalService.updateEval(123, "jean");

        assertEquals(result, evalService.getEvalById(123));
    }

    @Test
    public void delete_by_id_ok() {
        when(this.evalRepository.findById(anyInt())).thenReturn(Optional.of(EvalEntity.builder().build()));
        final EvalEntity result = this.evalService.updateEval(123, "jean");
        this.evalService.deleteEval(123);
        assertNotEquals(result, evalService.getEvalById(123));
    }


}
