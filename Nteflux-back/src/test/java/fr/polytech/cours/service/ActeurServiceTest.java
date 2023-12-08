package fr.polytech.cours.service;

import fr.polytech.cours.entity.ActeurEntity;
import fr.polytech.cours.exception.InvalidValueException;
import fr.polytech.cours.exception.ResourceNotFoundException;
import fr.polytech.cours.repository.ActeurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActeurServiceTest {

    @Mock
    private ActeurRepository acteurRepository;

    @InjectMocks
    private ActeurService acteurService;

    @Test
    public void update_livre_with_null_name() {
        assertThrows(InvalidValueException.class, () -> this.acteurService.updateLivre(0, null));
    }

    @Test
    public void update_livre_with_non_existing_livre() {
        assertThrows(ResourceNotFoundException.class, () -> this.acteurService.updateLivre(0, "toto"));
    }

    @Test
    public void update_livre_ok() {
        when(this.acteurRepository.findById(anyInt())).thenReturn(Optional.of(ActeurEntity.builder().build()));
        final ActeurEntity result = this.acteurService.updateLivre(123, "toto");

        assertEquals("toto", result.getTitre());
    }

}
