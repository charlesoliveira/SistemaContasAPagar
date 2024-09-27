package com.example.contasapagar.domain.usecases.listarConta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarContasOutputData {

    private Long id;

    @JsonProperty("data_vencimento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String data_vencimento;

    @JsonProperty("data_pagamento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String data_pagamento;

    @JsonProperty("valor")
    private String valor;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("situacao")
    private String situacao;
}
