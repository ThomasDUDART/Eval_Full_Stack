package fr.polytech.cours.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddSerieDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max = 3)
    private String nom;

}
