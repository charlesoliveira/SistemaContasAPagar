package com.example.contasapagar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.contasapagar")
@EnableJpaRepositories(basePackages="com.example.contasapagar")
public class ContasAPagarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContasAPagarApplication.class, args);
    }

}
