package br.com.unifaj.poo;

public class ExibindoMatrix {
    public static void main(String[] args) {
        int[][] matriz = {
                {4, 8 , 16 , 32 , 64 },
                {3, 6 , 9 , 12 ,15 , 18},
                {2, 4, 6, 8, 10 , 12 , 14 , 16}
        };

        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][0] + " " + matriz[i][1]);
            for (int j = 0; j < i - 1; j++) {
                System.out.print(matriz[i][j] + " " + matriz[i][j + 1]);
            }
            System.out.println();
        }
    }
}
