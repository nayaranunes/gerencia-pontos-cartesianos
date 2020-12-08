package com.br.gerenciapontos.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ponto")
@NoArgsConstructor
public class PontoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ponto_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "abscissa")
    private Double x;

    @Column(name = "ordenada")
    private Double y;

    @Column(name = "quadrante")
    private Integer quadrante;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public PontoEntity(Double x, Double y) {
        this.x = x;
        this.y = y;
        this.createdAt = LocalDateTime.now();
        this.quadrante = setQuadrante(x, y);
    }

    private Integer setQuadrante(Double x, Double y) {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        return 0; //eixo
    }

    public Double getDistancia(Double pX, Double pY) {
        return Math.sqrt(Math.pow((pX-x),2) + Math.pow((pY-y),2));
    }
}
