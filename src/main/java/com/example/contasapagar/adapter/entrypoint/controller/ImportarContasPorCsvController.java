package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.commons.utils.CsvUtility;
import com.example.contasapagar.domain.usecases.importarContaCsv.ImportarContasPorCsvUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/contas/importar")
public class ImportarContasPorCsvController {

    @Autowired
    private ImportarContasPorCsvUseCase importarContasPorCsvUseCase;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> importarArquivo(
            @RequestParam("file") MultipartFile inputFile) throws IOException {
        if (CsvUtility.hasCSVFormat(inputFile)) {
            importarContasPorCsvUseCase.executar(CsvUtility.converterCSV(inputFile.getInputStream()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload an csv file!");
    }
}
