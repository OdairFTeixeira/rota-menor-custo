package com.rota.menor.custo.dijikstra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustoPedagioViagemDto {

    private static final BigDecimal PRECO_MEDIO_GASOLINA = BigDecimal.valueOf(5.70);

    private BigDecimal carro;
    private BigDecimal moto;
    private BigDecimal caminhao;
    private BigDecimal microOnibus;
    private BigDecimal onibus;

    public CustoPedagioViagemDto(Integer qtdPedagios) {
        this.carro = BigDecimal.valueOf(qtdPedagios * 3.5);
        this.moto =  BigDecimal.valueOf(qtdPedagios * 2);
        this.caminhao = BigDecimal.valueOf(qtdPedagios * 9.6);
        this.microOnibus =  BigDecimal.valueOf(qtdPedagios * 7.0);
        this.onibus =  BigDecimal.valueOf(qtdPedagios * 10.5);
    }
}
