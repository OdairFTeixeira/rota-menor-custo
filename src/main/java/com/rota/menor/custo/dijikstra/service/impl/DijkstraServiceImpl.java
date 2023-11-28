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
        Map<String, Map<String, BigDecimal>> grafo = new HashMap<>();
        Map<String, ResultadoDto> resultados = new HashMap<>();

        gerarArestasGrafo(arestas, grafo);
        PriorityQueue<String> filaPrioridade = criaFilaPrioridade(resultados);

        zerarDistanciaCidadeOrigem(inicio, grafo, resultados, filaPrioridade);

        while (!filaPrioridade.isEmpty()) {
            String cidadeAtual = filaPrioridade.poll();

            for (Map.Entry<String, BigDecimal> vizinho : grafo.get(cidadeAtual).entrySet()) {
                BigDecimal novaDistancia = resultados.get(cidadeAtual).getDistanciaTotal().add(vizinho.getValue());
                List<CidadeDestinoDto> novoCaminho = new ArrayList<>(resultados.get(cidadeAtual).getCaminho());
                novoCaminho.add(new CidadeDestinoDto(cidadeAtual, vizinho.getKey(), vizinho.getValue()));

                if (novaDistancia.compareTo(resultados.get(vizinho.getKey()).getDistanciaTotal()) < 0) {
                    resultados.put(vizinho.getKey(), new ResultadoDto(novaDistancia, novoCaminho));
                    filaPrioridade.remove(vizinho.getKey());
                    filaPrioridade.add(vizinho.getKey());
                }
            }
        }

        return resultados.get(fim);
    }

    private void gerarArestasGrafo(List<CidadeDestinoDto> arestas, Map<String, Map<String, BigDecimal>> grafo) {
        for (CidadeDestinoDto aresta : arestas) {
            grafo.computeIfAbsent(aresta.getOrigem(), k -> new HashMap<>()).put(aresta.getDestino(), aresta.getDistancia());
            grafo.computeIfAbsent(aresta.getDestino(), k -> new HashMap<>()).put(aresta.getOrigem(), aresta.getDistancia());
        }
    }

    private PriorityQueue<String> criaFilaPrioridade(Map<String, ResultadoDto> resultado) {
        return new PriorityQueue<>(Comparator.comparing(resultado::get,
                Comparator.nullsFirst(Comparator.comparing(ResultadoDto::getDistanciaTotal))));
    }

    private void zerarDistanciaCidadeOrigem(String inicio, Map<String, Map<String, BigDecimal>> grafo, Map<String, ResultadoDto> resultado, PriorityQueue<String> filaPrioridade) {
        for (String cidade : grafo.keySet()) {
            resultado.put(cidade, new ResultadoDto(cidade.equals(inicio) ? BigDecimal.ZERO : BigDecimal.valueOf(9999), new ArrayList<>()));
            filaPrioridade.add(cidade);
        }
    }
}
