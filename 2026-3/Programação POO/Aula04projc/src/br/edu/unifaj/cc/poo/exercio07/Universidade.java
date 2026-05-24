package br.edu.unifaj.cc.poo.exercio07;

public class Universidade {
    private String nome;
    private Curso curso1;
    private Curso curso2;
    private Curso curso3;

    public Universidade(){

    }

    public Universidade(String nome, Curso curso1, Curso curso2, Curso curso3) {
        this.nome = nome;
        this.curso1 = curso1;
        this.curso2 = curso2;
        this.curso3 = curso3;
    }

    public Curso getCurso3() {
        return curso3;
    }

    public void setCurso3(Curso curso3) {
        this.curso3 = curso3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso1() {
        return curso1;
    }

    public void setCurso1(Curso curso1) {
        this.curso1 = curso1;
    }

    public Curso getCurso2() {
        return curso2;
    }

    public void setCurso2(Curso curso2) {
        this.curso2 = curso2;
    }
}
