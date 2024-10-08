package com.example.contasapagar.domain.usecases.listarConta.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutputData;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ListarContasOutputConverter {
    public Page<ListarContasOutputData> converter (List<Conta> listagem, PageRequest pageRequest) {
        List<ListarContasOutputData> output = listagem.stream().map(item -> ListarContasOutputData.builder()
                .id(item.getId())
                .data_vencimento(item.getDataVencimento().toString())
                .data_pagamento(item.getDataPagamento().toString())
                .descricao(item.getDescricao())
                .valor(item.getValor().toString())
                .situacao(item.getSituacao())
                .build()).collect(Collectors.toList());
        return new PageImpl<>(output, pageRequest, listagem.size());
    }

}
