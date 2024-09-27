package com.example.contasapagar.domain.usecases.listarContaPorId.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutputData;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ListarContasPorIdOutputConverter {
    public List<ListarContasOutputData> converter (List<Conta> listagem) {
        List<ListarContasOutputData> output = listagem.stream().map(item -> ListarContasOutputData.builder()
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
