package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.domain.usecases.listarContaPorId.ListarContasPorIdUseCase;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutputData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contas/{id}")
public class ListarContasPorIdController {

    @Autowired
    private final ListarContasPorIdUseCase listarContasPorIdUseCase;

    @GetMapping
    public ResponseEntity<List<ListarContasOutputData>> listarContas(
            @PathVariable(value = "id", required = false) Long id
    ) {
        List<ListarContasOutputData> output = listarContasPorIdUseCase.executar(id);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
