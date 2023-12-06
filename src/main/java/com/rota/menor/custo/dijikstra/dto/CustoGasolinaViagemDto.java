package com.rota.menor.custo.dijikstra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustoGasolinaViagemDto {

    private static final BigDecimal PRECO_MEDIO_GASOLINA = BigDecimal.valueOf(5.70);

    private BigDecimal carro;
    private BigDecimal moto;
    private BigDecimal caminhao;
    private BigDecimal microOnibus;
    private BigDecimal onibus;

    public CustoGasolinaViagemDto(BigDecimal distancia) {
        this.carro = (distancia.divide(BigDecimal.valueOf(15), RoundingMode.HALF_UP)).multiply(PRECO_MEDIO_GASOLINA);
        this.moto = (distancia.divide(BigDecimal.valueOf(25), RoundingMode.HALF_UP)).multiply(PRECO_MEDIO_GASOLINA);
        this.caminhao = (distancia.divide(BigDecimal.valueOf(7.5), RoundingMode.HALF_UP)).multiply(PRECO_MEDIO_GASOLINA);
        this.microOnibus = (distancia.divide(BigDecimal.valueOf(10), RoundingMode.HALF_UP)).multiply(PRECO_MEDIO_GASOLINA);
        this.onibus = (distancia.divide(BigDecimal.valueOf(5.5), RoundingMode.HALF_UP)).multiply(PRECO_MEDIO_GASOLINA);
    }
}
