package com.rota.menor.custo.dijikstra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cidade_destino")
public class CidadeDestinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String origem;

    private String destino;

    private BigDecimal distancia;
}
