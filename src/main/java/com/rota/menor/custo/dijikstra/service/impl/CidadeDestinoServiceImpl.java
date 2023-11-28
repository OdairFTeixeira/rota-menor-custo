package com.rota.menor.custo.dijikstra.service.impl;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;
import com.rota.menor.custo.dijikstra.entity.CidadeDestinoEntity;
import com.rota.menor.custo.dijikstra.service.CidadeDestinoService;
import com.rota.menor.custo.dijikstra.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeDestinoServiceImpl implements CidadeDestinoService {

    @Autowired
    private DijkstraService dijkstraService;

    @Override
    public List<CidadeDestinoDto> buscarDistanciasCidades() {
        List<CidadeDestinoEntity> cidadesDestinos = getAllArestas();
        return cidadesDestinos.stream().map(CidadeDestinoDto::new).collect(Collectors.toList());
    }

    @Override
    public ResultadoDto buscarRotaMenorCusto(String origem, String destino) {
        return dijkstraService.dijkstra(buscarDistanciasCidades(), origem, destino);
    }

    private List<CidadeDestinoEntity> getAllArestas() {
        List<CidadeDestinoEntity> listaCidadesDestino = new ArrayList<>();
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Imbaú Pr", new BigDecimal("35.1")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Reserva Pr", new BigDecimal("87.7")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Telêmaco Borba Pr", new BigDecimal("52.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Reserva Pr", new BigDecimal("52.9")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Telêmaco Borba Pr", new BigDecimal("24.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Tibagi Pr", new BigDecimal("51.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Reserva Pr", "Tibagi Pr", new BigDecimal("89.0")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Telêmaco Borba Pr", new BigDecimal("45.1")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Ventania Pr", new BigDecimal("48.9")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Piraí do Sul Pr", new BigDecimal("92.5")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Castro Pr", new BigDecimal("64.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Carambei Pr", new BigDecimal("83.9")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Ponta Grossa Pr", new BigDecimal("94.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Telêmaco Borba Pr", "Ventania Pr", new BigDecimal("85.8")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ventania Pr", "Arapoti Pr", new BigDecimal("58.4")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ventania Pr", "Piraí do Sul Pr", new BigDecimal("55.4")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Arapoti Pr", "Jaguariaiva Pr", new BigDecimal("23.0")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Arapoti Pr", "Piraí do Sul Pr", new BigDecimal("62.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Sengês Pr", "Jaguariaiva Pr", new BigDecimal("36.5")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Jaguariaiva Pr", "Piraí do Sul Pr", new BigDecimal("46.7")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Piraí do Sul Pr", "Castro Pr", new BigDecimal("34.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Castro Pr", "Carambei Pr", new BigDecimal("23.6")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Castro Pr", "Ponta Grossa Pr", new BigDecimal("44.4")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Carambei Pr", "Ponta Grossa Pr", new BigDecimal("23.2")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ponta Grossa Pr", "Palmeira Pr", new BigDecimal("45.2")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Palmeira Pr", "Ponta Grossa Pr", new BigDecimal("45.0")));
        return listaCidadesDestino;
    }
}
