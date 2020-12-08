package com.br.gerenciapontos.service;

import com.br.gerenciapontos.domain.entity.PontoEntity;
import com.br.gerenciapontos.domain.request.PontoDistanciaRequest;
import com.br.gerenciapontos.domain.request.PontoRequest;
import com.br.gerenciapontos.domain.response.PontoInexistenteResponse;
import com.br.gerenciapontos.domain.response.PontoResponse;
import com.br.gerenciapontos.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class PontoService {

    private final PontoRepository pontoRepository;

    @Autowired
    public PontoService(PontoRepository pontoRepository) {
        this.pontoRepository = pontoRepository;
    }

    public PontoResponse create(PontoRequest pontoRequest) {

        //unique
        if (this.pontoRepository.findByXAndY(pontoRequest.getX(), pontoRequest.getY()).isPresent())
            throw new RuntimeException("Coordenadas já cadastradas!");

        PontoEntity ponto = this.pontoRepository.save(new PontoEntity(pontoRequest.getX(), pontoRequest.getY()));

        return entityToResponse(ponto);

    }

    private PontoResponse entityToResponse(PontoEntity ponto) {
        return new PontoResponse(ponto.getX(), ponto.getY(), ponto.getQuadrante(), ponto.getCreatedAt());
    }

    public Set<PontoResponse> getAll() {
        Set<PontoResponse> responses = new HashSet<>();
        List<PontoEntity> pontos = this.pontoRepository.findAll();
        pontos.forEach(ponto -> responses.add(this.entityToResponse(ponto)));
        return responses;
    }

    public Object getByCoordenadas(PontoRequest pontoRequest) {
        this.repositorioVazio();
        Optional<PontoEntity> pontoEntity = this.pontoRepository.findByXAndY(pontoRequest.getX(), pontoRequest.getY());

        if (pontoEntity.isEmpty()) return new PontoInexistenteResponse("Coordenadas não cadastradas!");
        else return this.entityToResponse(pontoEntity.get());
    }

    public List<PontoEntity> get(PontoDistanciaRequest request) {
        this.repositorioVazio();
        Double distancia = request.getDistancia();
        return this.pontoRepository.findAllByDistancia(request.getPX(), request.getPY(), distancia*distancia);

    }
    public Set<PontoResponse> getAllByDistancia(PontoDistanciaRequest request) {

        this.repositorioVazio();
        Double distancia = request.getDistancia();
        List<PontoEntity> pontos = this.pontoRepository.findAll();

        Set<PontoResponse> responses = new HashSet<>();

        pontos.forEach(ponto -> {
            if (ponto.getDistancia(request.getPX(), request.getPY()) < request.getDistancia()) {
                responses.add(this.entityToResponse(ponto));
            }
        });
        return responses;
    }

    private void repositorioVazio() {
        List<PontoEntity> pontos = this.pontoRepository.findAll();
        if (pontos.isEmpty()) throw new RuntimeException("Não há nenhum ponto na base de dados!");
    }
}
