package com.rota.menor.custo.dijikstra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CidadeDestinoEntity {

    private String origem;

    private String destino;

    private BigDecimal distancia;
    
    private BigDecimal tempoPadraoDeslocamento;
}
