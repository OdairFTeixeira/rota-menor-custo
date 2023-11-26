package com.rota.menor.custo.dijikstra.service;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;

import java.util.List;

public interface DijkstraService {

    ResultadoDto dijkstra(List<CidadeDestinoDto> arestas, String inicio, String fim);
}
