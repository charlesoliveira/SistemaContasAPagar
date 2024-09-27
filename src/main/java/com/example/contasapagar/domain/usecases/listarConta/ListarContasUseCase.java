package com.example.contasapagar.domain.usecases.listarConta;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.listarConta.converter.ListarContasOutputConverter;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Builder
public class ListarContasUseCase {

    @Autowired
    @Qualifier("IContaDataProvider")
    private IContaDataProvider iContaDataProvider;

    @Autowired
    private ListarContasOutputConverter outputConverter;

    public Page<ListarContasOutputData> executar(PageRequest pageRequest) {
        List<Conta> listagem = iContaDataProvider.findAll();
        return outputConverter.converter(listagem, pageRequest);
    }
}
