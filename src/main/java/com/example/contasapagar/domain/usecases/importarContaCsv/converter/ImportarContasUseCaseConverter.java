package com.example.contasapagar.domain.usecases.importarContaCsv.converter;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.importarContaCsv.ImportarContasUseCaseInPutData;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ImportarContasUseCaseConverter {

    public static List<Conta> to(List<ImportarContasUseCaseInPutData> inputList) {
        return inputList.stream().map( item -> {
            Conta conta = new Conta();
                conta.setDataPagamento(item.getData_pagamento());
                conta.setDataVencimento(item.getData_vencimento());
                conta.setValor(item.getValor());
                conta.setDescricao(item.getDescricao());
                conta.setSituacao(item.getSituacao());
            return conta;
        }).collect(Collectors.toList());
    }
}
