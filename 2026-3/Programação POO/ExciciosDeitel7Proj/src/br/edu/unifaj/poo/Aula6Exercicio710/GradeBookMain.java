package br.edu.unifaj.poo.Aula6Exercicio710;

public class GradeBookMain {

    public static void main(String[] args) {

        System.out.println("RA: 12529495");
        System.out.println("NOME: Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME: Otavio Siqueira");

        int[] notasArray = {
                87, 68, 94, 100, 83,
                78, 85, 91, 76, 87
        };

        GradeBook meuLivroDeNotas =
                new GradeBook(
                        "POO - Introdução à Programação em Java",
                        notasArray
                );

        System.out.printf(
                "%nBem-vindo ao livro de notas da disciplina:%n%s%n%n",
                meuLivroDeNotas.getCourseName()
        );

        meuLivroDeNotas.processGrades();
    }
}