package com.rota.menor.custo.dijikstra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDto {

    private BigDecimal distanciaTotal;
    private List<CidadeDestinoDto> caminho;
}

