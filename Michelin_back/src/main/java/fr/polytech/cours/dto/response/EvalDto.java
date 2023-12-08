package fr.polytech.cours.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.cours.entity.EvalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvalDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("evaluater")
    private String evaluater;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("star")
    private Integer star;

    @JsonProperty("datecreation")
    private Date datecreation;

    public static EvalDto buildFromEntity(EvalEntity evalEntity) {
        return EvalDto.builder()
                .id(evalEntity.getId())
                .evaluater(evalEntity.getEvaluater())
                .comment(evalEntity.getComment())
                .star(evalEntity.getStar())
                .datecreation(evalEntity.getDatecreation())
                .build();
    }

}
