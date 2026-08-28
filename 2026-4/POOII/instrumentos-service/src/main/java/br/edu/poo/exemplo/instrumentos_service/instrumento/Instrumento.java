package br.edu.poo.exemplo.instrumentos_service.instrumento;

import lombok.Data;

@Data
public class Instrumento {
    private int id;
    private String nome;
    private String tipo;
    private float preco;
    private String descricao;
}
