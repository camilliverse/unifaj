package br.edu.unifaj.poo.Aula6Exercicio716;

import java.util.ArrayList;

public class Ex16{
    public static void main(String[] args){

        System.out.println("RA: 12529495");
        System.out.println("NOME:Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME:Otavio Siqueira");

        ArrayList<String> nomes = new ArrayList<>();

        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Fernanda");
        nomes.add("Lucas");
        nomes.add("Mariana");

        System.out.println("\nLista de nomes:");

        for(String nome:nomes){
            System.out.println(nome);
        }

        nomes.remove("Carlos");

        System.out.println("\nLista após remover Carlos:");

        for(String nome:nomes){
            System.out.println(nome);
        }

        System.out.println("\nTotal de elementos: "+nomes.size());
    }
}