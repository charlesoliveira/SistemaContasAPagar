package com.example.contasapagar.factory;

import com.example.contasapagar.domain.usecases.listarConta.converter.ListarContasOutputConverter;
import com.example.contasapagar.domain.usecases.listarContaPorId.ListarContasPorIdUseCase;
import com.example.contasapagar.domain.usecases.listarContaPorId.converter.ListarContasPorIdOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ListarContasPorIdUseCaseFactory {

    @Bean
    @DependsOn("criarListarContasPorIdOutputConverter")
    public ListarContasPorIdUseCase criarListarContasPorIdUseCase(ListarContasOutputConverter outputConverter) {
        return ListarContasPorIdUseCase.builder().build();
    }

    @Bean
    public ListarContasPorIdOutputConverter criarListarContasPorIdOutputConverter() {
        return ListarContasPorIdOutputConverter.builder().build();
    }
}
