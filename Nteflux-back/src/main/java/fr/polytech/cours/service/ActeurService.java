package fr.polytech.cours.service;

import fr.polytech.cours.dto.request.AddActeurDto;
import fr.polytech.cours.entity.ActeurEntity;
import fr.polytech.cours.exception.InvalidValueException;
import fr.polytech.cours.exception.ResourceNotFoundException;
import fr.polytech.cours.repository.ActeurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActeurService {

    private final ActeurRepository acteurRepository;

    private final S3Service s3Service;

    public List<ActeurEntity> getLivres() {
        return this.acteurRepository.findAll();
    }

    public List<ActeurEntity> getLivres(final List<Integer> idsToFetch) {
        return this.acteurRepository.findAllById(idsToFetch);
    }

    public ActeurEntity getLivreById(final Integer id) {
        return this.acteurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livre with id " + id + " + not found"));
    }

    public ActeurEntity addLivre(final AddActeurDto livreDto) {
        final ActeurEntity livreToInsert = ActeurEntity.builder().titre(livreDto.getTitre()).build();

        return this.acteurRepository.save(livreToInsert);
    }

    public void deleteLivre(final Integer id) {
        this.acteurRepository.deleteById(id);
    }

    public ActeurEntity updateLivre(int id, String nouveauNom) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }
        final ActeurEntity livreToUpdate = this.acteurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("le livre d'id " + id + " n'existe pas"));
        livreToUpdate.setTitre(nouveauNom);
        acteurRepository.save(livreToUpdate);
        return livreToUpdate;
    }

    public String getCoverDownloadUrl(final Integer livreId) {
        this.getLivreById(livreId);

        return this.s3Service.getDownloadUrl("TOTO_" + livreId);
    }

    public String putCoverDownloadUrl(final Integer livreId) {
        this.getLivreById(livreId);

        return this.s3Service.putDownloadUrl("TOTO_" + livreId);
    }

}
