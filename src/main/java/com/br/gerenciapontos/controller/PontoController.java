package com.br.gerenciapontos.controller;

import com.br.gerenciapontos.domain.request.PontoDistanciaRequest;
import com.br.gerenciapontos.domain.request.PontoRequest;
import com.br.gerenciapontos.domain.response.PontoResponse;
import com.br.gerenciapontos.service.PontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("ponto")
public class PontoController {

    private final PontoService pontoService;

    @Autowired
    public PontoController(PontoService pontoService) {
        this.pontoService = pontoService;
    }

    @PostMapping
    public ResponseEntity<PontoResponse> create(@Valid @RequestBody PontoRequest pontoRequest) {
        PontoResponse pontoResponse = this.pontoService.create(pontoRequest);
        return ResponseEntity.ok(pontoResponse);
    }

    @GetMapping("/unico")
    public ResponseEntity<Object> getPonto(@Valid @RequestBody PontoRequest pontoRequest) {
        Object ponto = this.pontoService.getByCoordenadas(pontoRequest);

        return ResponseEntity.ok(ponto);
    }

    /*
        Dado um ponto P(Xp, Yp) encontrar todos os pontos Q,
        tais que a distância de P e Q seja menor que D
        (Xp, Yp e D são parâmetros que seu serviço deve receber).
    */

    @GetMapping("/distancia")
    public ResponseEntity distancia(@Valid @RequestBody PontoDistanciaRequest request) {
        return ResponseEntity.ok(this.pontoService.get(request));
    }

    @GetMapping("/todos")
    public ResponseEntity<Set<PontoResponse>> getAll() {
        Set<PontoResponse> pontos = this.pontoService.getAll();
        return ResponseEntity.ok(pontos);
    }

}
