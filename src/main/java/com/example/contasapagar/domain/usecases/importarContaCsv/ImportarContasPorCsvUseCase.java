package com.example.contasapagar.domain.usecases.importarContaCsv;

import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.importarContaCsv.converter.ImportarContasUseCaseConverter;
import com.example.contasapagar.domain.usecases.inserirConta.exceptions.InserirContaUseCaseException;
import io.micrometer.common.util.StringUtils;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Builder
public class ImportarContasPorCsvUseCase {

    @Autowired
    private IContaDataProvider contaDataProvider;
    private ImportarContasUseCaseConverter importarContasUseCaseConverter;

    public ImportarContasUseCaseOutPutData executar(List<ImportarContasUseCaseInPutData> inputData) {
        inputData.stream().forEach(item -> {
            validarCamposObrigatorios(item);
        });
        salvarContas(inputData);
        return null;
    }

    private void validarCamposObrigatorios(ImportarContasUseCaseInPutData inputData) {
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

    private void salvarContas(List<ImportarContasUseCaseInPutData> inputDataList) {
        contaDataProvider.saveAll(importarContasUseCaseConverter.to(inputDataList));
    }
}
