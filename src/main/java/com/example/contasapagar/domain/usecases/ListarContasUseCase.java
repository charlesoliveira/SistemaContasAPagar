package com.example.contasapagar.domain.usecases;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.conta.ListarContasOutput;
import com.example.contasapagar.domain.usecases.conta.converter.ListarContasOutputConverter;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Builder
public class ListarContasUseCase {

    @Autowired
    @Qualifier("IContaDataProvider")
    private IContaDataProvider iContaDataProvider;

    @Autowired
    private ListarContasOutputConverter outputConverter;

    public List<ListarContasOutput> executar() {
        List<Conta> listagem = iContaDataProvider.findAll();
        return outputConverter.converter(listagem);
    }
}
