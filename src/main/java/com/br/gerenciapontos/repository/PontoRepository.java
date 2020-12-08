package com.br.gerenciapontos.repository;

import com.br.gerenciapontos.domain.entity.PontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PontoRepository extends JpaRepository<PontoEntity, Long> {

    Optional<PontoEntity> findByXAndY(Double abscissa, Double ordenada);

    @Query("select p from PontoEntity p where (((p.x - :pX)*(p.x - :pX)) + ((p.y - :pY)*(p.y - :pY))) <= :d")
    List<PontoEntity> findAllByDistancia(Double pX, Double pY, Double d);
}
