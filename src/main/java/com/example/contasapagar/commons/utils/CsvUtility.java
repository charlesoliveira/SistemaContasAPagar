package com.example.contasapagar.commons.utils;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.usecases.inserirConta.exceptions.InserirContaUseCaseException;
import io.micrometer.common.util.StringUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
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

    public static List<Conta> converterCSV(InputStream is) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(bReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Conta> contasList = new ArrayList<Conta>();
            csvParser.getRecords().forEach(record -> {
                Conta conta = new Conta();
                try {
                    conta.setDataVencimento(converteDataDDMMYYYY(record.get("data_vencimento")));
                    conta.setDataPagamento(converteDataDDMMYYYY(record.get("data_pagamento")));
                    conta.setValor(Float.parseFloat(record.get("valor")));
                    conta.setDescricao(record.get("descricao"));
                    conta.setSituacao(record.get("situracao"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                validaCsv(conta);
                contasList.add(conta);
            });
            return contasList;
        } catch (IOException e) {
            throw new RuntimeException("CSV data is failed to parse: " + e.getMessage());
        }
    }

    private static void validaCsv(Conta conta) {
        if (StringUtils.isEmpty(conta.getDataPagamento().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo data_pagamento.");
        }
        if (StringUtils.isEmpty(conta.getDataVencimento().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo data_vencimento.");
        }
        if (StringUtils.isEmpty(conta.getValor().toString())) {
            throw new InserirContaUseCaseException("Não foi informado o campo valor.");
        }
        if (StringUtils.isEmpty(conta.getDescricao())) {
            throw new InserirContaUseCaseException("Não foi informado o campo descricao.");
        }
        if (StringUtils.isEmpty(conta.getSituacao())) {
            throw new InserirContaUseCaseException("Não foi informado o campo situacao.");
        }
    }

    private static Date converteDataDDMMYYYY(String inputDate) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
    }
}
