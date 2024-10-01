package com.example.contasapagar.factory;

import com.example.contasapagar.domain.usecases.alterarSituacaoConta.AlterarSituacaoContaUseCase;
import com.example.contasapagar.domain.usecases.alterarSituacaoConta.converter.AlterarSituacaoContaUseCaseConverver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlterarSituacaoContaUseCaseFactory {

    @Bean
    public AlterarSituacaoContaUseCase criarAlterarSituacaoContaUseCase() {
        return AlterarSituacaoContaUseCase.builder()
                .alterarSituacaoContaUseCaseConverver(new AlterarSituacaoContaUseCaseConverver())
                .build();
    }
}
