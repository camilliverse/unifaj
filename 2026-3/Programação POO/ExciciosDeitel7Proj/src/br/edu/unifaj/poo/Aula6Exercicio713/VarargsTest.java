package br.edu.unifaj.poo.Aula6Exercicio713;

public class VarargsTest {

    public static double media(double... numeros) {

        double total = 0.0;

        for (double numero : numeros) {
            total += numero;
        }

        return total / numeros.length;
    }

    public static void main(String[] args) {

        System.out.println("RA: 12529495");
        System.out.println("NOME: Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME: Otavio Siqueira");

        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;

        System.out.printf(
                "d1 = %.1f%nd2 = %.1f%nd3 = %.1f%nd4 = %.1f%n%n",
                d1, d2, d3, d4
        );

        System.out.printf(
                "Média de d1 e d2: %.1f%n",
                media(d1, d2)
        );

        System.out.printf(
                "Média de d1, d2 e d3: %.1f%n",
                media(d1, d2, d3)
        );

        System.out.printf(
                "Média de d1, d2, d3 e d4: %.1f%n",
                media(d1, d2, d3, d4)
        );
    }
}