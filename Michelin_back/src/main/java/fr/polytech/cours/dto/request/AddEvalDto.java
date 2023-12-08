package fr.polytech.cours.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEvalDto {

    @JsonProperty("evaluater")
    @Size(max = 50)
    private String evaluater;

    @JsonProperty("comment")
    @Size(max = 255)
    private String comment;

    @JsonProperty("star")
    @Size(max = 1)
    private Integer star;

    @JsonProperty("datecreation")
    private Date datecreation = new Date();


}
