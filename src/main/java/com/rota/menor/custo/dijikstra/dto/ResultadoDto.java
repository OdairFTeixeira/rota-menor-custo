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

    private BigDecimal tempoTotal;

    private List<CidadeDestinoDto> caminho;

    public CustoGasolinaViagemDto getCustoViagem() {
        return new CustoGasolinaViagemDto(distanciaTotal);
    }

    public BigDecimal getCustoRefeicao() {
        return BigDecimal.valueOf(70);
    }

    public BigDecimal getTempoMedioCarro() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioMoto() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(120), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioOnibus() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(80), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioCaminhao() {
        return Objects.nonNull(distanciaTotal) ?
                distanciaTotal.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }
}

