package com.rota.menor.custo.dijikstra.dto;

import com.rota.menor.custo.dijikstra.entity.CidadeDestinoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDestinoDto {

    private Long id;

    private String origem;

    private String destino;

    private BigDecimal distancia;

    public CidadeDestinoDto(CidadeDestinoEntity cidadeDestinoEntity) {
        this.id = cidadeDestinoEntity.getId();
        this.origem = cidadeDestinoEntity.getOrigem();
        this.destino = cidadeDestinoEntity.getDestino();
        this.distancia = cidadeDestinoEntity.getDistancia();
    }
}
