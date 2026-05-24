package br.edu.unifaj.cc.poo.exercio07;

public class Professor {
    private String nome;
    private String titularidade;

    public Professor(){

    }

    public Professor(String nome, String titularidade) {
        this.nome = nome;
        this.titularidade = titularidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitularidade() {
        return titularidade;
    }

    public void setTitularidade(String titularidade) {
        this.titularidade = titularidade;
    }
}
