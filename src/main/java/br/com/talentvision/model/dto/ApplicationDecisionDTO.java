package br.com.talentvision.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApplicationDecisionDTO {
    private String idUser;
    private String applicationDescription;
    private boolean decision;
    private String message;

}
