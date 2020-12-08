package com.br.gerenciapontos.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PontoDistanciaRequest {

    @JsonProperty(value = "pX")
    @NotNull(message = "Um ponto deve ter uma coordenada X")
    private Double pX;

    @JsonProperty(value = "pY")
    @NotNull(message = "Um ponto deve ter uma coordenada Y")
    private Double pY;

    @JsonProperty(value = "distancia")
    @NotNull(message = "Essa operação requer um valor de distancia")
    private Double distancia;
}
