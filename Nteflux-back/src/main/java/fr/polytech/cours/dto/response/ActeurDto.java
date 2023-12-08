package fr.polytech.cours.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.cours.entity.ActeurEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActeurDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("titre")
    private String titre;

    @JsonProperty("commentaires")
    private List<CommentaireDto> commentaires;

    public static ActeurDto buildFromEntity(ActeurEntity acteurEntity) {
        return ActeurDto.builder()
                .id(acteurEntity.getId())
                .titre(acteurEntity.getTitre())
                .commentaires(acteurEntity.getCommentaires() != null ? acteurEntity.getCommentaires().stream().map(commentaireEntity -> CommentaireDto.buildFromEntity(commentaireEntity)).toList() : new ArrayList<>())
                .build();
    }

}
