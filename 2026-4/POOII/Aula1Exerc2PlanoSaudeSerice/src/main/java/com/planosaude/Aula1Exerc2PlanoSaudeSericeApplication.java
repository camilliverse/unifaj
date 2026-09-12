package com.planosaude;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Aula 1 - Exercicio 2 - Spring Boot
 * REST de "Plano de Saude" com as entidades Medico e Beneficiario.
 *
 * ==========================================================
 *  ATENCAO: substitua os valores abaixo pelo seu RA e Nome.
 * ==========================================================
 */
@SpringBootApplication
public class Aula1Exerc2PlanoSaudeSericeApplication {

    // TODO: preencher com os dados reais do aluno
    public static final String RA_ALUNO = "RA0000000";
    public static final String NOME_ALUNO = "SEU NOME COMPLETO AQUI";

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" Aula 1 - Exercicio 2 - Plano de Saude Service");
        System.out.println(" RA:   " + RA_ALUNO);
        System.out.println(" Nome: " + NOME_ALUNO);
        System.out.println("==========================================================");

        SpringApplication.run(Aula1Exerc2PlanoSaudeSericeApplication.class, args);
    }

    /**
     * Reforca a exibicao do RA/Nome apos a aplicacao subir, no log do Spring.
     */
    @Bean
    public CommandLineRunner exibirDadosAluno() {
        return args -> {
            System.out.println(">> Servico 'Plano de Saude' iniciado por " + NOME_ALUNO + " (" + RA_ALUNO + ")");
            System.out.println(">> Endpoints disponiveis em http://localhost:8080/api/planosaude/...");
        };
    }
}
