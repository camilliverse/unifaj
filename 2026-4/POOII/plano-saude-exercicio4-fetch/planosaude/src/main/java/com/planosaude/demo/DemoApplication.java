package com.planosaude.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Projeto Plano de Saude - Exercicio 4 (Aula 3) - JavaScript Fetch
 * Tema: Plano de Saude (Pacientes, Medicos, Fisioterapeutas, Hospitais, Clinicas...)
 *
 * Este projeto implementa o CRUD (Listar, Incluir, Alterar, Excluir) via
 * REST + Fetch para 2 classes do dominio: Medico e Paciente.
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
