package com.example.contasapagar.application.factory.usecase;

import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCase;
import com.example.contasapagar.domain.usecases.inserirConta.converter.InserirContaUseCaseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InserirContaUseCaseFactory {

    @Bean
    public InserirContaUseCase createInserirContaUseCase() {
        return InserirContaUseCase.builder()
                .inserirContaUseCaseConverter(new InserirContaUseCaseConverter())
                .build();
    }
}
