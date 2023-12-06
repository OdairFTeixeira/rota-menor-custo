package com.rota.menor.custo.dijikstra.dto;

import com.rota.menor.custo.dijikstra.entity.CidadeDestinoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CidadeDestinoDto {

    private String origem;

    private String destino;

    private BigDecimal distancia;

    private BigDecimal tempoPadraoDeslocamento;

    public CidadeDestinoDto(CidadeDestinoEntity cidadeDestinoEntity) {
        this.origem = cidadeDestinoEntity.getOrigem();
        this.destino = cidadeDestinoEntity.getDestino();
        this.distancia = cidadeDestinoEntity.getDistancia();
        this.tempoPadraoDeslocamento = cidadeDestinoEntity.getTempoPadraoDeslocamento();
    }

    public BigDecimal getTempoMedioCarro() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioMoto() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(120), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioOnibus() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(80), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioMicroOnibus() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(90), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal getTempoMedioCaminhao() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }
}
