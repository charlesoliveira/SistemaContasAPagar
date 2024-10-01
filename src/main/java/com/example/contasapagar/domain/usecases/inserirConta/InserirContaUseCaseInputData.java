package com.example.contasapagar.domain.usecases.inserirConta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class InserirContaUseCaseInputData {

    private Date data_vencimento;

    private Date data_pagamento;

    private Float valor;

    private String descricao;

    private int situacao;
}
