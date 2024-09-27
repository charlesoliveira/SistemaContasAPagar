package com.example.contasapagar.domain.usecases.inserirConta.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCaseInputData;
import lombok.Data;

@Data
public class InserirContaUseCaseConverter {

    public Conta to(InserirContaUseCaseInputData inputData) {
        return Conta.builder()
                .dataPagamento(inputData.getData_pagamento())
                .dataVencimento(inputData.getData_vencimento())
                .valor(inputData.getValor())
                .descricao(inputData.getDescricao())
                .situacao(inputData.getSituacao())
                .build();
    }
}
