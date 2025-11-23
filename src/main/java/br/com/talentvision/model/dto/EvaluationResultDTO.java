package br.com.talentvision.model.dto;

import br.com.talentvision.model.ResultStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EvaluationResultDTO {

    private String idUser;
    private Double score;
    private ResultStatus status;
}
