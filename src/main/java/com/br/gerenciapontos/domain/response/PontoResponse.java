package com.br.gerenciapontos.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PontoResponse {

    @JsonProperty(value = "abscissa-X")
    private final Double abscissaX;

    @JsonProperty(value = "ordenada-Y")
    private final Double ordenadaY;

    private final Integer quadrante;

    @JsonProperty(value = "created-at")
    private final LocalDateTime createdAt;

    public PontoResponse(Double x, Double y, Integer quadrante, LocalDateTime createdAt) {
        this.abscissaX = x;
        this.ordenadaY = y;
        this.quadrante = quadrante;
        this.createdAt = createdAt;
    }
}
