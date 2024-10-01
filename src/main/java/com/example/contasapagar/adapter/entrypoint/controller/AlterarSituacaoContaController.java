package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.domain.usecases.alterarSituacaoConta.AlterarSituacaoContaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/contas/{id}")
public class AlterarSituacaoContaController {

    @Autowired
    private AlterarSituacaoContaUseCase alterarSituacaoContaUseCase;

    @Transactional
    @PutMapping
    public ResponseEntity<?> alterarSituacaoConta(
            @PathVariable(value = "id") Long id,
            @RequestParam int situacao){
        alterarSituacaoContaUseCase.executar(id, situacao);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }
}
