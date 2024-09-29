package com.example.contasapagar.factory;

import com.example.contasapagar.domain.usecases.importarContaCsv.ImportarContasPorCsvUseCase;
import com.example.contasapagar.domain.usecases.importarContaCsv.converter.ImportarContasUseCaseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImportarContasPorCsvUseCaseFactory {

    @Bean
    public ImportarContasPorCsvUseCase criarImportarContasPorCsvUseCase() {
        return ImportarContasPorCsvUseCase.builder()
                .importarContasUseCaseConverter(new ImportarContasUseCaseConverter())
                .build();
    }

}
