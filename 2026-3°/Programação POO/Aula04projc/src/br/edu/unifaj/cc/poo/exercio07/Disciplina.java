package br.edu.unifaj.cc.poo.exercio07;

public class Disciplina {
    private String nome;
    private Professor prof;

    public Disciplina(){

    }

    public Disciplina(String nome, Professor prof) {
        this.nome = nome;
        this.prof = prof;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProf() {
        return prof;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }
}
