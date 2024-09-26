package com.example.contasapagar.controller;

import com.example.contasapagar.domain.usecases.ListarContasUseCase;
import com.example.contasapagar.domain.usecases.conta.ListarContasOutput;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private final ListarContasUseCase listarContasUseCase;

    @GetMapping
    public ResponseEntity<List<ListarContasOutput>> listarContas() {
        List<ListarContasOutput> output = listarContasUseCase.executar();
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
