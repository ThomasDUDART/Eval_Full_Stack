package fr.polytech.cours.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.cours.entity.FinalEvalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinalEvalDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("decider")
    private String decider;

    @JsonProperty("star")
    private Integer star;

    @JsonProperty("texte")
    private String texte;

    public static FinalEvalDto buildFromEntity(FinalEvalEntity finalEvalEntity) {
        return FinalEvalDto.builder()
                .id(finalEvalEntity.getId())
                .decider(finalEvalEntity.getDecider())
                .star(finalEvalEntity.getStar())
                .texte(finalEvalEntity.getTexte()).build();
    }

}
