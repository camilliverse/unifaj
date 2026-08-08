package br.edu.unifaj.poo.Aula6Exercicio712;

public class MainBidimensional {

    public static void main(String[] args) {

        System.out.println("RA: 12529495");
        System.out.println("NOME: Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME: Otavio Siqueira");

        int[][] notasArray = {

                {87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82}
        };

        Bidimensional b =
                new Bidimensional(
                        notasArray
                );

        b.outputGrades();

        System.out.println();

        b.outputBarChart();
    }
}