package fr.polytech.cours.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.cours.entity.EvalEntity;
import fr.polytech.cours.entity.FinalEvalEntity;
import fr.polytech.cours.entity.RestaurantEntity;
import jakarta.validation.constraints.Size;
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
public class RestaurantDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max = 255)
    private String adresse;

    /*@JsonProperty("restau")
    private List<EvalDto> eval; //Commenter car problème de requête simulatannées en essayant de les inestanciés, même nul, avec le restau

    @JsonProperty("restau")
    private FinalEvalEntity dernier;*/

    private String tag;//Note à moi-même add que ce soit une liste déroulante ou issue d'une liste à chercher le mieux serait une table de tag

    public static RestaurantDto buildFromEntity(RestaurantEntity restaurantEntity) {

        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                //.eval(restaurantEntity.getEval() != null ? restaurantEntity.getEval().stream().map(evalEntity -> EvalDto.buildFromEntity(evalEntity)).toList(): new ArrayList<EvalDto>())
                //.dernier(restaurantEntity.getDernier() != null ? restaurantEntity.getDernier(): new FinalEvalEntity())
                .build();
    }

}
