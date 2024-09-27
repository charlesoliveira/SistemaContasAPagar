package com.example.contasapagar.domain.usecases.listarConta.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutput;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ListarContasOutputConverter {
    public List<ListarContasOutput> converter (List<Conta> listagem) {
        List<ListarContasOutput> output = listagem.stream().map(item -> ListarContasOutput.builder()
                .id(item.getId())
                .data_vencimento(item.getDataVencimento().toString())
                .data_pagamento(item.getDataPagamento().toString())
                .descricao(item.getDescricao())
                .valor(item.getValor().toString())
                .situacao(item.getSituacao())
                .build()).collect(Collectors.toList());
        return output;
    }

}
