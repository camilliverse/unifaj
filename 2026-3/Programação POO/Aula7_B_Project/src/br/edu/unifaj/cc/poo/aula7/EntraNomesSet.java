package br.edu.unifaj.cc.poo.aula7;

import java.util.*;

public class EntraNomesSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Set<String> nomes = new TreeSet<>();
        Set<String> nomes = new HashSet<>();
                System.out.println("Digite vários nomes.  Vazio para terminar");
        while (true) {
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()) {
                break;
            }
            nomes.add(nome);
        }

        // Ordenar a lista
        //Collections.sort(nomes);  Não tem ordenação

        //Exibir os nomes
        for (String nome: nomes) {
            System.out.println(nome);  //Não tem posição get(i)
        }
        System.out.println("Fim do programa set");
    }
}
