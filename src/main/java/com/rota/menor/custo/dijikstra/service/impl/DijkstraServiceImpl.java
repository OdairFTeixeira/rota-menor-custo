package com.rota.menor.custo.dijikstra.service.impl;

import com.rota.menor.custo.dijikstra.dto.CidadeDestinoDto;
import com.rota.menor.custo.dijikstra.dto.ResultadoDto;
import com.rota.menor.custo.dijikstra.service.DijkstraService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class DijkstraServiceImpl implements DijkstraService {

    @Override
    public ResultadoDto dijkstra(List<CidadeDestinoDto> arestas, String inicio, String fim) {
        Map<String, Map<String, CidadeDestinoDto>> grafo = new HashMap<>();
        Map<String, ResultadoDto> resultados = new HashMap<>();

        gerarArestasGrafo(arestas, grafo);
        PriorityQueue<String> filaPrioridade = criaFilaPrioridade(resultados);

        zerarDistanciaCidadeOrigem(inicio, grafo, resultados, filaPrioridade);

        while (!filaPrioridade.isEmpty()) {
            String cidadeAtual = filaPrioridade.poll();

            for (Map.Entry<String, CidadeDestinoDto> vizinho : grafo.get(cidadeAtual).entrySet()) {
                CidadeDestinoDto aresta = vizinho.getValue();
                BigDecimal novaDistancia = resultados.get(cidadeAtual).getDistanciaTotal().add(aresta.getDistancia());
                BigDecimal novoTempo = resultados.get(cidadeAtual).getTempoTotal().add(aresta.getTempoPadraoDeslocamento());

                if (novaDistancia.compareTo(resultados.get(vizinho.getKey()).getDistanciaTotal()) < 0) {
                    List<CidadeDestinoDto> novoCaminho = new ArrayList<>(resultados.get(cidadeAtual).getCaminho());
                    novoCaminho.add(new CidadeDestinoDto(cidadeAtual, vizinho.getKey(), aresta.getDistancia(), aresta.getTempoPadraoDeslocamento()));

                    resultados.put(vizinho.getKey(), new ResultadoDto(novaDistancia, novoTempo, novoCaminho));
                    filaPrioridade.remove(vizinho.getKey());
                    filaPrioridade.add(vizinho.getKey());
                }
            }
        }

        return resultados.get(fim);
    }

    private void gerarArestasGrafo(List<CidadeDestinoDto> arestas, Map<String, Map<String, CidadeDestinoDto>> grafo) {
        for (CidadeDestinoDto aresta : arestas) {
            grafo.computeIfAbsent(aresta.getOrigem(), k -> new HashMap<>()).put(aresta.getDestino(), aresta);
            grafo.computeIfAbsent(aresta.getDestino(), k -> new HashMap<>()).put(aresta.getOrigem(), aresta);
        }
    }

    private PriorityQueue<String> criaFilaPrioridade(Map<String, ResultadoDto> resultado) {
        return new PriorityQueue<>(Comparator.comparing(resultado::get,
                Comparator.nullsFirst(Comparator.comparing(ResultadoDto::getDistanciaTotal))));
    }

    private void zerarDistanciaCidadeOrigem(String inicio, Map<String, Map<String, CidadeDestinoDto>> grafo, Map<String, ResultadoDto> resultado, PriorityQueue<String> filaPrioridade) {
        for (String cidade : grafo.keySet()) {
            resultado.put(cidade, new ResultadoDto(
                    cidade.equals(inicio) ? BigDecimal.ZERO : BigDecimal.valueOf(9999),
                    BigDecimal.ZERO,
                    new ArrayList<>()));
            filaPrioridade.add(cidade);
        }
    }

}
