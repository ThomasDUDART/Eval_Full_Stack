package fr.polytech.cours.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SerieDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max = 100)
    private String nom;

    @JsonProperty("livres")
    private List<ActeurDto> livres;

    @Min(0)
    @Max(3)
    private Integer note;

}
