package br.edu.unifaj.poo.ex01;

public class Aluno {
    private int RA;
    private String nome;
    private int idade;
    private String turma;

    public Aluno(int RA, String nome, int idade, String turma) {
        this.RA = RA;
        this.nome = nome;
        this.idade = idade;
        this.turma = turma;
    }


    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "\nRA:" + RA +
                "\nNome: " + nome +
                "\nIdade: " + idade +
                "\nTurma: " + turma;
    }





}
