package com.rota.menor.custo.dijikstra.repository;

import com.rota.menor.custo.dijikstra.entity.CidadeDestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeDestinoRepository extends JpaRepository<CidadeDestinoEntity, Long> {
}
