package br.edu.unifaj.cc.poo.exercio07;

public class Curso {
    private String nome;

    private Disciplina disc1;
    private Disciplina dic12;
    private Disciplina disc3;

    public Curso(){

    }

    public Disciplina getDisc3() {
        return disc3;
    }

    public void setDisc3(Disciplina disc3) {
        this.disc3 = disc3;
    }

    public Curso(String nome, Disciplina disc1, Disciplina dic12, Disciplina disc3) {
        this.nome = nome;
        this.disc1 = disc1;
        this.dic12 = dic12;
        this.disc3 = disc3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina getDisc1() {
        return disc1;
    }

    public void setDisc1(Disciplina disc1) {
        this.disc1 = disc1;
    }

    public Disciplina getDic12() {
        return dic12;
    }

    public void setDic12(Disciplina dic12) {
        this.dic12 = dic12;
    }
}
