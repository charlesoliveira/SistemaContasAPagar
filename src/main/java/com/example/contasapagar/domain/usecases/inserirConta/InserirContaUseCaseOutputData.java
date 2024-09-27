package com.example.contasapagar.domain.usecases.inserirConta;

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
    private Date data_vencimento;

    @Column(name = "dataPagamento")
    private Date data_pagamento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "situacao")
    private String situacao;
}
