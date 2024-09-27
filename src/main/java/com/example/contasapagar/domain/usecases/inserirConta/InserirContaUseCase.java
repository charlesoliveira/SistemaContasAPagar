package com.example.contasapagar.domain.usecases.inserirConta;

import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.inserirConta.converter.InserirContaUseCaseConverter;
import com.example.contasapagar.domain.usecases.inserirConta.exceptions.InserirContaUseCaseException;
import io.micrometer.common.util.StringUtils;
import lombok.Builder;

@Builder
public class InserirContaUseCase {

    private IContaDataProvider contaDataProvider;
    private InserirContaUseCaseConverter inserirContaUseCaseConverter;

    public InserirContaUseCaseOutputData executar(InserirContaUseCaseInputData inputData) {
        validarCamposObrigatorios(inputData);
        salvarConta(inputData);
        return InserirContaUseCaseOutputData.builder().build();
    }

    private void validarCamposObrigatorios(InserirContaUseCaseInputData inputData) {
        if (StringUtils.isEmpty(inputData.getData_pagamento().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo data_pagamento.");
        }
        if (StringUtils.isEmpty(inputData.getData_vencimento().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo data_vencimento.");
        }
        if (StringUtils.isEmpty(inputData.getValor().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo valor.");
        }
        if (StringUtils.isEmpty(inputData.getDescricao())) {
            throw new InserirContaUseCaseException("Não foi informado o campo descricao.");
        }
        if (StringUtils.isEmpty(inputData.getSituacao())) {
            throw new InserirContaUseCaseException("Não foi informado o campo situacao.");
        }
    }


    private void salvarConta(InserirContaUseCaseInputData inputData) {
        contaDataProvider.save(inserirContaUseCaseConverter.to(inputData));

    }
}
