package br.edu.unifaj.poo.ex01;

public class Correcao {
    private Aluno aluno;
    private Exercicio exercicio;
    private double nota;

    public Correcao(Aluno aluno, Exercicio exercicio, double nota) {
        this.aluno = aluno;
        this.exercicio = exercicio;

        if (nota > exercicio.getNotaMaxima()) {
            this.nota = exercicio.getNotaMaxima();
        } else {
            this.nota = nota;
        }
    }

    public double getPercentual() {
        return (nota / exercicio.getNotaMaxima()) * 100;
    }

    @Override
    public String toString() {
        return aluno +
                "\n\n" + exercicio +
                "\n\nNota do Aluno: " + nota +
                "\nAproveitamento: " + String.format("%.2f", getPercentual()) + "%";
    }
}