package com.example.contasapagar.domain.usecases.listarContaPorId;

import com.example.contasapagar.domain.entities.Conta;
import com.example.contasapagar.domain.interfaces.IContaDataProvider;
import com.example.contasapagar.domain.usecases.listarConta.ListarContasOutputData;
import com.example.contasapagar.domain.usecases.listarConta.converter.ListarContasOutputConverter;
import com.example.contasapagar.domain.usecases.listarContaPorId.converter.ListarContasPorIdOutputConverter;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
public class ListarContasPorIdUseCase {

    @Autowired
    @Qualifier("IContaDataProvider")
    private IContaDataProvider iContaDataProvider;

    @Autowired
    private ListarContasPorIdOutputConverter outputConverter;

    public List<ListarContasOutputData> executar(Long id) {
        List<Conta> listagem = new ArrayList<>();
        Optional<Conta> conta = iContaDataProvider.findById(id);
        if (conta.isPresent()) {
            listagem = conta.stream().toList();
        }
        return outputConverter.converter(listagem);
    }
}
