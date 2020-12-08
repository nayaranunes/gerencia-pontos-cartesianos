package com.br.gerenciapontos.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PontoRequest {

    @NotNull(message = "Um ponto deve ter uma coordenada X")
    private Double x;

    @NotNull(message = "Um ponto deve ter uma coordenada Y")
    private Double y;

}
