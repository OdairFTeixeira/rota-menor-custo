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
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Imbaú Pr", new BigDecimal("35.1"), new BigDecimal("0.39")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Reserva Pr", new BigDecimal("87.7"),  new BigDecimal("1.29")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ortigueira Pr", "Telêmaco Borba Pr", new BigDecimal("52.6"),  new BigDecimal("1.0")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Reserva Pr", new BigDecimal("52.9"),  new BigDecimal("0.55")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Telêmaco Borba Pr", new BigDecimal("24.6"),  new BigDecimal("0.28")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Imbaú Pr", "Tibagi Pr", new BigDecimal("51.6"),  new BigDecimal("0.49")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Reserva Pr", "Tibagi Pr", new BigDecimal("89.0"),  new BigDecimal("1.30")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Telêmaco Borba Pr", new BigDecimal("45.1"),  new BigDecimal("0.51")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Ventania Pr", new BigDecimal("46.0"),  new BigDecimal("0.49")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Piraí do Sul Pr", new BigDecimal("92.1"),  new BigDecimal("1.23")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Castro Pr", new BigDecimal("64.2"),  new BigDecimal("0.58")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Carambei Pr", new BigDecimal("83.5"),  new BigDecimal("1.12")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Tibagi Pr", "Ponta Grossa Pr", new BigDecimal("94.6"),  new BigDecimal("1.29")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Telêmaco Borba Pr", "Ventania Pr", new BigDecimal("82.9"),  new BigDecimal("1.19")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ventania Pr", "Arapoti Pr", new BigDecimal("59.0"),  new BigDecimal("0.56")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ventania Pr", "Piraí do Sul Pr", new BigDecimal("56.0"),  new BigDecimal("0.52")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Arapoti Pr", "Jaguariaiva Pr", new BigDecimal("23.0"),  new BigDecimal("0.29")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Arapoti Pr", "Piraí do Sul Pr", new BigDecimal("62.6"),  new BigDecimal("1.03")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Sengês Pr", "Jaguariaiva Pr", new BigDecimal("36.8"),  new BigDecimal("0.44")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Jaguariaiva Pr", "Piraí do Sul Pr", new BigDecimal("46.7"),  new BigDecimal("0.50")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Piraí do Sul Pr", "Castro Pr", new BigDecimal("34.6"),  new BigDecimal("0.32")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Castro Pr", "Carambei Pr", new BigDecimal("22.6"),  new BigDecimal("0.21")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Castro Pr", "Ponta Grossa Pr", new BigDecimal("43.4"),  new BigDecimal("0.44")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Carambei Pr", "Ponta Grossa Pr", new BigDecimal("23.2"),  new BigDecimal("0.28")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Ponta Grossa Pr", "Palmeira Pr", new BigDecimal("45.2"),  new BigDecimal("0.51")));
        listaCidadesDestino.add(new CidadeDestinoEntity("Palmeira Pr", "Ponta Grossa Pr", new BigDecimal("45.0"),  new BigDecimal("0.56")));

        return listaCidadesDestino;
    }
}
