package br.edu.unifaj.poo.Aula6Exercicio712;

public class Bidimensional {

    private int[][] notas;

    public Bidimensional(int[][] notas) {
         this.notas = notas;
    }

    public double getAverage(int[] conjuntoNotas) {

        int total = 0;

        for (int nota : conjuntoNotas) {
            total += nota;
        }
        return (double) total /
                conjuntoNotas.length;
    }
    public void outputBarChart() {
        System.out.println(
                "Distribuição geral das notas:"
        );
        int[] frequencia =
                new int[11];
        for (
                int[] notasAluno : notas) {

            for (
                    int nota : notasAluno) {
                ++frequencia[nota / 10];
            }
        }

        for (int contador = 0;
                contador < frequencia.length;
                contador++) {

            if (contador == 10) {
                System.out.printf(
                        "%5d: ",
                        100);
            } else {
                System.out.printf(
                        "%02d-%02d: ",
                        contador * 10,
                        contador * 10 + 9);
            }

            for (int estrelas = 0;
                    estrelas < frequencia[contador];
                    estrelas++) {

                System.out.print("*");
            }

            System.out.println();
        }
    }
    public void outputGrades() {

        System.out.println("As notas são:\n");

        System.out.print("              ");

        for (int prova = 0; prova < notas[0].length; prova++) {

            System.out.printf("Prova %d    ", prova + 1);
        }

        System.out.println("Média");

        for (int aluno = 0; aluno < notas.length; aluno++) {

            System.out.printf("Aluno %2d   ", aluno + 1);

            for (int prova : notas[aluno]) {

                System.out.printf(
                        "%8d",
                        prova);
            }

            double media = getAverage(notas[aluno]);
            System.out.printf(
                    "%10.2f%n",
                    media);
        }
    }
}