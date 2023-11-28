package com.rota.menor.custo.dijikstra.controller;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;
import com.rota.menor.custo.dijikstra.service.CidadeDestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cidade-destino")
public class CidadeDestinoController {

    @Autowired
    private CidadeDestinoService cidadeDestinoService;

    @GetMapping("/buscar-cidades-destino")
    public List<CidadeDestinoDto> buscarCidadesDestino() {
        return cidadeDestinoService.buscarDistanciasCidades();
    }

    @GetMapping("rota-menor-custo")
    public ResultadoDto buscarRotaMenorCusto(@RequestParam String origem, @RequestParam String destino) {
        return cidadeDestinoService.buscarRotaMenorCusto(origem, destino);
    }
}
