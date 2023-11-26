package com.rota.menor.custo.dijikstra.service.impl;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;
import com.rota.menor.custo.dijikstra.entity.CidadeDestinoEntity;
import com.rota.menor.custo.dijikstra.repository.CidadeDestinoRepository;
import com.rota.menor.custo.dijikstra.service.CidadeDestinoService;
import com.rota.menor.custo.dijikstra.service.DijkstraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeDestinoServiceImpl implements CidadeDestinoService {

    @Autowired
    private CidadeDestinoRepository cidadeDestinoRepository;

    @Autowired
    private DijkstraService dijkstraService;

    @Override
    public List<CidadeDestinoDto> buscarDistanciasCidades() {
        List<CidadeDestinoEntity> cidadesDestinos = cidadeDestinoRepository.findAll();
        return cidadesDestinos.stream().map(CidadeDestinoDto::new).collect(Collectors.toList());
    }

    @Override
    public ResultadoDto buscarRotaMenorCusto(String origem, String destino) {
        return dijkstraService.dijkstra(buscarDistanciasCidades(), origem, destino);
    }
}
