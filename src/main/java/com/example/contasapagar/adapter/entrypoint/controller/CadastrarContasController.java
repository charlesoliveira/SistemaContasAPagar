package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCase;
import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCaseInputData;
import com.example.contasapagar.domain.usecases.inserirConta.InserirContaUseCaseOutputData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/contas")
public class CadastrarContasController {

    @Autowired
    private InserirContaUseCase inserirContaUseCase;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrarContas(
            @RequestBody InserirContaUseCaseInputData inputData) {
        inserirContaUseCase.executar(inputData);
        return new ResponseEntity<>("", HttpStatus.CREATED);

    }
}
