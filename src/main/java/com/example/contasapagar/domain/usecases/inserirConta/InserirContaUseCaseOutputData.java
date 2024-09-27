package com.example.contasapagar.domain.usecases.inserirConta;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CONTA")
public class InserirContaUseCaseOutputData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "dataVencimento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data_vencimento;

    @Column(name = "dataPagamento")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date data_pagamento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "situacao")
    private String situacao;
}
