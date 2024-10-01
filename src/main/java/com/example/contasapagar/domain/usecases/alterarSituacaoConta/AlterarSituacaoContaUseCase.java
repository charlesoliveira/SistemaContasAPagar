package com.example.contasapagar.domain.usecases.alterarSituacaoConta;

import com.example.contasapagar.commons.enums.EnumSituacaoConta;
import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.alterarSituacaoConta.converter.AlterarSituacaoContaUseCaseConverver;
import com.example.contasapagar.domain.usecases.alterarSituacaoConta.exceptions.AlterarSituacaoContaUseCaseException;
import com.example.contasapagar.domain.usecases.inserirConta.exceptions.InserirContaUseCaseException;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Builder
public class AlterarSituacaoContaUseCase {

    @Autowired
    private IContaDataProvider contaDataProvider;
    private AlterarSituacaoContaUseCaseConverver alterarSituacaoContaUseCaseConverver;

    public AlterarSituacaoContaOutputData executar(Long id, int situacao) {

        validaDadosAlteracao(id, situacao);
        Conta conta = new Conta();

        if (!buscarContaPorId(id).isPresent()) {
            throw new AlterarSituacaoContaUseCaseException("Não foi localizada uma Conta com esse id.");
        }
        conta = buscarContaPorId(id).get();
        conta.setSituacao(EnumSituacaoConta.getValueById(situacao));
        alterarConta(conta);
        return AlterarSituacaoContaOutputData.builder().build();
    }

    private void validaDadosAlteracao(Long id, int situacao) {

        if (id.longValue() < 1) {
            throw new AlterarSituacaoContaUseCaseException("O id informado não existe.");
        }
        if (EnumSituacaoConta.getValueById(situacao) == null) {
            throw new InserirContaUseCaseException("A situação de conta informada não existe..");
        }
    }

    private Optional<Conta> buscarContaPorId(long id) {
        return contaDataProvider.findById(id).or(() -> Optional.empty());
    }

    private void alterarConta(Conta conta) {
        contaDataProvider.save(conta);
    }

}
