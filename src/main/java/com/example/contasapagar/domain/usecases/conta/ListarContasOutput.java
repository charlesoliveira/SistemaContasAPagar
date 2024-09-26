package com.example.contasapagar.domain.usecases.conta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ListarContasOutput {

    private Long id;

    @JsonProperty("data_vencimento")
    private String data_vencimento;

    @JsonProperty("data_pagamento")
    private String data_pagamento;

    @JsonProperty("valor")
    private String valor;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("situacao")
    private String situacao;
}
