package br.edu.unifaj.cc.aula04_jdbc_service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;


}
