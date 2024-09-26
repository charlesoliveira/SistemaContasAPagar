package com.example.contasapagar.domain.usecases.conta.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.conta.ListarContasOutput;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ListarContasOutputConverter {
    public List<ListarContasOutput> converter (List<Conta> listagem) {
        List<ListarContasOutput> output = listagem.stream().map(item -> ListarContasOutput.builder()
                .id(item.getId())
                .data_vencimento(item.getDataVencimento())
                .data_pagamento(item.getDataPagamento())
                .descricao(item.getDescricao())
                .valor(item.getValor())
                .situacao(item.getSituacao())
                .build()).collect(Collectors.toList());
        return output;
    }

}
