package com.example.contasapagar.domain.usecases.conta;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarContasOutput {

    private Long id;

    private String data_vencimento;

    private String data_pagamento;

    private String valor;

    private String descricao;

    private String situacao;
}
