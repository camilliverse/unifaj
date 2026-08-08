package br.edu.unifaj.poo.Aula6Exercicio717;

import java.util.ArrayList;

public class Ex717{
    public static void main(String[] args){

        System.out.println("RA: 12529495");
        System.out.println("NOME:Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME:Otavio Siqueira");

        ArrayList<Integer> numeros=new ArrayList<>();

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);

        int soma=0;

        System.out.println("\nNúmeros armazenados:");

        for(int numero:numeros){
            System.out.println(numero);
            soma+=numero;
        }

        double media=(double)soma/numeros.size();

        System.out.println("\nSoma = "+soma);
        System.out.println("Média = "+media);
    }
}