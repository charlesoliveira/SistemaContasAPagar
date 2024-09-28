package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.commons.utils.CsvUtility;
import com.example.contasapagar.domain.usecases.importarContaCsv.ImportarContaPorCsvUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/contas/importar")
public class ImportarContasPorCsvController {

    @Autowired
    private ImportarContaPorCsvUseCase importarContaPorCsvUseCase;

    @Transactional
    @PostMapping
    public ResponseEntity<?> importarArquivo(
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (CsvUtility.hasCSVFormat(file)) {
            importarContaPorCsvUseCase.executar(CsvUtility.converterCSV(file.getInputStream()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an csv file!");
    }
}
