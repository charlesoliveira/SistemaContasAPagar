package com.example.contasapagar.domain.usecases.importarContaCsv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImportarContasUseCaseInPutData {

    private Long id;

    private Date data_vencimento;

    private Date data_pagamento;

    private Float valor;

    private String descricao;

    private String situacao;
}
