package fr.polytech.cours.service;

import fr.polytech.cours.dto.request.AddSerieDto;
import fr.polytech.cours.dto.response.SerieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final List<SerieDto> biblios = new ArrayList<>();

    public List<SerieDto> getAllBiblios() {
        return this.biblios;
    }

    public SerieDto addBiblio(AddSerieDto addSerieDto) {
        final SerieDto result = SerieDto.builder().id(addSerieDto.getId()).nom(addSerieDto.getNom()).livres(new ArrayList<>()).build();
        this.biblios.add(result);

        return result;
    }

    public void removeDeChaqueBiblio(final Integer id) {
        this.biblios.forEach(serieDto ->
                serieDto.setLivres(
                        serieDto.getLivres()
                                .stream()
                                .filter(livreDto -> !livreDto.getId().equals(id))
                                .toList())
        );

    }

}
