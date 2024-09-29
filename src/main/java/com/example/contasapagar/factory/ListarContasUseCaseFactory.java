package com.example.contasapagar.factory;

import com.example.contasapagar.domain.usecases.listarConta.ListarContasUseCase;
import com.example.contasapagar.domain.usecases.listarConta.converter.ListarContasOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ListarContasUseCaseFactory {

    @Bean
    @DependsOn("criarListarContasOutputConverter")
    public ListarContasUseCase criarListarContasUseCase(ListarContasOutputConverter outputConverter) {
        return ListarContasUseCase.builder().build();
    }

    @Bean
    public ListarContasOutputConverter criarListarContasOutputConverter() {
        return ListarContasOutputConverter.builder().build();
    }
}
