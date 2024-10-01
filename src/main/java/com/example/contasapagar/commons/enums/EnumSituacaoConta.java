package com.example.contasapagar.commons.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static java.util.Objects.isNull;

public enum EnumSituacaoConta {
    A_VENCER(1, "a vencer"),
    VENCIDA(2, "vencida"),
    PAGA(3, "paga");

    private int id;
    private String value;

    EnumSituacaoConta(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static String getValueById(int id) {
        for(EnumSituacaoConta enumSituacaoConta : values()) {
            if(enumSituacaoConta.getId() == id) {
                return enumSituacaoConta.getValue();
            }
        }
        return null;
    }

    public static String verificaSituacaoByDate(Date dataVencimento, Date dataPagamento) {
        if (isNull(dataPagamento)) {
            if (dataVencimento.before(Calendar.getInstance().getTime())) {
                return EnumSituacaoConta.A_VENCER.getValue();
            } else {
                return EnumSituacaoConta.VENCIDA.getValue();
            }
        } else {
            return EnumSituacaoConta.PAGA.getValue();
        }
    }

    private static Date converteDataDDMMYYYY(String inputDate) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy").parse(inputDate);
    }
}
