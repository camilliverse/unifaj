package br.edu.unifaj.poo.Aula6Exercicio711;

public class Multidimensional {

    public static void mostrarArray(int[][] array) {

        for (int linha = 0; linha < array.length; linha++) {

            for (int coluna = 0;
                 coluna < array[linha].length;
                 coluna++) {

                System.out.printf(
                        "%d ",
                        array[linha][coluna]
                );
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("RA: 12529495");
        System.out.println("NOME: Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME: Otavio Siqueira");

        // array 1
        int[][] array1 =
                new int[2][3];

        array1[0][0] = 1;
        array1[0][1] = 2;
        array1[0][2] = 3;

        array1[1][0] = 4;
        array1[1][1] = 5;
        array1[1][2] = 6;

        // array 2
        int[][] array2 =
                new int[3][];

        array2[0] =
                new int[2];

        array2[1] =
                new int[1];

        array2[2] =
                new int[3];

        array2[0][0] = 1;
        array2[0][1] = 2;

        array2[1][0] = 3;

        array2[2][0] = 4;
        array2[2][1] = 5;
        array2[2][2] = 6;

        System.out.println(
                "\nValores do array1 por linha:"
        );

        mostrarArray(array1);

        System.out.println(
                "\nValores do array2 por linha:"
        );

        mostrarArray(array2);
    }
}