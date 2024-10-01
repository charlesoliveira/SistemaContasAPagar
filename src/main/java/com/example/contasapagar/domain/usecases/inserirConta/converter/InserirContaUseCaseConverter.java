package com.example.contasapagar.domain.usecases.inserirConta.converter;

import com.example.contasapagar.commons.enums.EnumSituacaoConta;
import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCaseInputData;
import lombok.Data;

import java.util.Date;

@Data
public class InserirContaUseCaseConverter {


    public Conta to(InserirContaUseCaseInputData inputData) {
        return Conta.builder()
                .dataPagamento(inputData.getData_pagamento())
                .dataVencimento(inputData.getData_vencimento())
                .valor(inputData.getValor())
                .descricao(inputData.getDescricao())
                .situacao(validaSituacao(inputData.getSituacao(), inputData.getData_vencimento(), inputData.getData_pagamento()))
                .build();
    }

    private String validaSituacao(int id, Date dataPagamento, Date dataVencimento) {
        if (EnumSituacaoConta.getValueById(id).equals(EnumSituacaoConta.verificaSituacaoByDate(dataVencimento, dataPagamento))) {
            return EnumSituacaoConta.getValueById(id).toString();
        } else {
            return EnumSituacaoConta.verificaSituacaoByDate(dataVencimento, dataPagamento);
        }
    }
}
