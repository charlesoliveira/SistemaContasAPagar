package com.example.contasapagar.commons.utils;

import com.example.contasapagar.commons.enums.EnumSituacaoConta;
import com.example.contasapagar.domain.usecases.importarContaCsv.ImportarContasUseCaseInPutData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvUtility {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"id", "data_vencimento", "data_pagamento", "valor", "descricao", "situacao"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        } else {
            return true;
        }
    }

    public static List<ImportarContasUseCaseInPutData> converterCSV(InputStream is) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(bReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<ImportarContasUseCaseInPutData> importList = new ArrayList<ImportarContasUseCaseInPutData>();
            csvParser.getRecords().forEach(record -> {
                ImportarContasUseCaseInPutData importData = new ImportarContasUseCaseInPutData();
                try {
                    importData.setData_vencimento(converteDataDDMMYYYY(record.get("data_vencimento")));
                    importData.setData_pagamento(converteDataDDMMYYYY(record.get("data_pagamento")));
                    importData.setValor(Float.parseFloat(record.get("valor")));
                    importData.setDescricao(record.get("descricao"));
                    importData.setSituacao(EnumSituacaoConta.getValueById(Integer.parseInt(record.get("situacao"))));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                importList.add(importData);
            });
            return importList;
        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }
    }

    private static Date converteDataDDMMYYYY(String inputDate) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
    }
}
