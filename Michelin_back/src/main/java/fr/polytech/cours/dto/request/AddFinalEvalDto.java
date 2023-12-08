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
public class AddFinalEvalDto {

    @JsonProperty("decider")
    @Size(max = 90)
    private String decider;

    @JsonProperty("star")
    @Size(max = 1)
    private Integer star;

    @JsonProperty("texte")
    private String texte;

}
