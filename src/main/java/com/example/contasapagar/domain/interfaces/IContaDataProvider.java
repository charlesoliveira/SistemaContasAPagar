package com.example.contasapagar.domain.interfaces;

import com.example.contasapagar.domain.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContaDataProvider extends JpaRepository<Conta, Long> {
}
