package br.edu.unifaj.cc.poo.aula8service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Servico {
    private Integer id;
    private String nome;
    private String descricao;
    private Double valor;
}

