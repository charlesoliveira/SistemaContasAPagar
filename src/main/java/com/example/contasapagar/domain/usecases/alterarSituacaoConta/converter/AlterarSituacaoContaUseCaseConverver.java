package com.example.contasapagar.domain.usecases.alterarSituacaoConta.converter;

import com.example.contasapagar.commons.enums.EnumSituacaoConta;
import com.example.contasapagar.domain.entities.Conta;
import lombok.Data;

@Data
public class AlterarSituacaoContaUseCaseConverver {

    public Conta to(Conta conta, int situacao) {
            conta.setSituacao(EnumSituacaoConta.getValueById(situacao));
            return conta;
    }
}
