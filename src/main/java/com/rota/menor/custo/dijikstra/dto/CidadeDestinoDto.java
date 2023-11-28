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

    private BigDecimal tempoMedioCarro;

    private BigDecimal tempoMedioMoto;

    private BigDecimal tempoMedioOnibus;

    private BigDecimal tempoMedioCaminhao;

    public CidadeDestinoDto(String origem, String destino, BigDecimal distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.tempoMedioCarro = calculaTempoMedioCarro();
        this.tempoMedioMoto = calculaTempoMedioMoto();
        this.tempoMedioOnibus = calculaTempoMedioOnibus();
        this.tempoMedioCaminhao = calculaTempoMedioCaminhao();
    }

    public CidadeDestinoDto(CidadeDestinoEntity cidadeDestinoEntity) {
        this.origem = cidadeDestinoEntity.getOrigem();
        this.destino = cidadeDestinoEntity.getDestino();
        this.distancia = cidadeDestinoEntity.getDistancia();
        this.tempoMedioCarro = calculaTempoMedioCarro();
        this.tempoMedioMoto = calculaTempoMedioMoto();
        this.tempoMedioOnibus = calculaTempoMedioOnibus();
        this.tempoMedioCaminhao = calculaTempoMedioCaminhao();
    }

    public BigDecimal calculaTempoMedioCarro() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioMoto() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(120), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioOnibus() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(80), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }

    public BigDecimal calculaTempoMedioCaminhao() {
        return Objects.nonNull(distancia) ?
                distancia.divide(BigDecimal.valueOf(60), 2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
    }
}
