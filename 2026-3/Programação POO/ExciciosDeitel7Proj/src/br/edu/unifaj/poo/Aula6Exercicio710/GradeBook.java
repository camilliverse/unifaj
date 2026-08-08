package br.edu.unifaj.poo.Aula6Exercicio710;

public class GradeBook {

    private String nomeCurso;
    private int[] notas;

    public GradeBook(
            String nomeCurso,
            int[] notas
    ) {

        this.nomeCurso = nomeCurso;
        this.notas = notas;
    }

    public void setCourseName(
            String nomeCurso
    ) {

        this.nomeCurso = nomeCurso;
    }

    public String getCourseName() {
        return nomeCurso;
    }

    public void processGrades() {

        mostrarNotas();

        System.out.printf(
                "%nMédia da turma: %.2f%n",
                getAverage()
        );

        System.out.printf(
                "Menor nota: %d%nMaior nota: %d%n%n",
                getMinimum(),
                getMaximum()
        );

        mostrarGraficoBarras();
    }

    public int getMinimum() {

        int menorNota = notas[0];

        for (int nota : notas) {

            if (nota < menorNota) {
                menorNota = nota;
            }
        }

        return menorNota;
    }

    public int getMaximum() {

        int maiorNota = notas[0];

        for (int nota : notas) {

            if (nota > maiorNota) {
                maiorNota = nota;
            }
        }

        return maiorNota;
    }

    public double getAverage() {

        int total = 0;

        for (int nota : notas) {
            total += nota;
        }

        return (double) total / notas.length;
    }

    public void mostrarGraficoBarras() {

        System.out.println(
                "Distribuição das notas:"
        );

        int[] frequencia =
                new int[11];

        for (int nota : notas) {
            ++frequencia[nota / 10];
        }

        for (
                int contador = 0;
                contador < frequencia.length;
                contador++
        ) {

            if (contador == 10) {

                System.out.printf(
                        "%5d: ",
                        100
                );

            } else {

                System.out.printf(
                        "%02d-%02d: ",
                        contador * 10,
                        contador * 10 + 9
                );
            }

            for (
                    int estrelas = 0;
                    estrelas < frequencia[contador];
                    estrelas++
            ) {

                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void mostrarNotas() {

        System.out.println(
                "As notas são:"
        );

        for (
                int aluno = 0;
                aluno < notas.length;
                aluno++
        ) {

            System.out.printf(
                    "Aluno %2d: %3d%n",
                    aluno + 1,
                    notas[aluno]
            );
        }
    }
}