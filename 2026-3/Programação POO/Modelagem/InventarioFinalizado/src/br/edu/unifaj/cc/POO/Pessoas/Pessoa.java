package br.edu.unifaj.cc.POO.Pessoas;

import br.edu.unifaj.cc.POO.Relatorios.Relatorio;

public abstract class Pessoa implements Relatorio {
    protected int id;
    protected String nome;
    protected String email;

    public Pessoa(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public abstract int calcularCargaHoraria();

    public String getNome() {
        return nome;
    }
}