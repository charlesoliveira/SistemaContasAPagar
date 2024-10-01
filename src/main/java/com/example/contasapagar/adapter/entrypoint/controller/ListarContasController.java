package com.example.contasapagar.adapter.entrypoint.controller;

import com.example.contasapagar.domain.usecases.listarConta.ListarContasUseCase;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutputData;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contas")
public class ListarContasController {

    @Autowired
    private final ListarContasUseCase listarContasUseCase;

    @GetMapping
    public Page<ListarContasOutputData> listarContas(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(required = false) String sortBy
    ) {
        if(null == page) page = 1;
        if(null == size) size = 10;
        if(StringUtils.isEmpty(sortBy)) sortBy ="id";
        return listarContasUseCase.executar(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}
