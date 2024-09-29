package com.example.contasapagar.commons.enums;

import java.util.Date;

public enum EnumSituacaoConta {
    A_VENCER("a vencer"),
    VENCIDA("vencida"),
    PAGA("paga");

    private String value;

    EnumSituacaoConta(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public String verificarSituacao(Date dataVencimento, Date dataPagamento) {
        return value;
    }
}
