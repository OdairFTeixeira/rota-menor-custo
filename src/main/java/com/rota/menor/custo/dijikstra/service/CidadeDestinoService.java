package com.rota.menor.custo.dijikstra.service;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;

import java.util.List;

public interface CidadeDestinoService {

    List<CidadeDestinoDto> buscarDistanciasCidades();

    ResultadoDto buscarRotaMenorCusto(String origem, String destino);
}
