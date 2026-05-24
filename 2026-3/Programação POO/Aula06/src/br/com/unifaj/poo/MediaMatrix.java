package br.com.unifaj.poo;

import java.util.Scanner;

public class MediaMatrix {
    public static void main(String[] args) {
        int[] vetor = {80, 10, 1000, 70, 7 , 4};
        float media = mediaNumeros(vetor);
        System.out.println("A media do vetor é: " + media);
    }

    private static float mediaNumeros(int[] vetor) {
        long total = 0;
        for (int i = 0; i < vetor.length; i++) {
            total += vetor[i];
        }
        return (float) total / (float) vetor.length;
    }
}
