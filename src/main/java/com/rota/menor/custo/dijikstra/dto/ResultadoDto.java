package com.rota.menor.custo.dijikstra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDto {

    private BigDecimal distanciaTotal;

    private List<CidadeDestinoDto> caminho;

    private BigDecimal tempoMedioCarro;

    private BigDecimal tempoMedioMoto;

    private BigDecimal tempoMedioOnibus;

    private BigDecimal tempoMedioCaminhao;

    public ResultadoDto(BigDecimal distanciaTotal, List<CidadeDestinoDto> caminho) {
        this.distanciaTotal = distanciaTotal;
        this.caminho = caminho;
        this.tempoMedioCarro = calculaTempoMedioCarro();
        this.tempoMedioMoto = calculaTempoMedioMoto();
        this.tempoMedioOnibus = calculaTempoMedioOnibus();
        this.tempoMedioCaminhao = calculaTempoMedioCaminhao();
    }

    public BigDecimal calculaTempoMedioCarro() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioMoto() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(120), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioOnibus() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(80), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioCaminhao() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }
}

