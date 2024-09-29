package com.example.contasapagar.factory;

import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCase;
import com.example.contasapagar.domain.usecases.inserirConta.converter.InserirContaUseCaseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirContaUseCaseFactory {

    @Bean
    public InserirContaUseCase criarInserirContaUseCase() {
        return InserirContaUseCase.builder()
                .inserirContaUseCaseConverter(new InserirContaUseCaseConverter())
                .build();
    }
}
