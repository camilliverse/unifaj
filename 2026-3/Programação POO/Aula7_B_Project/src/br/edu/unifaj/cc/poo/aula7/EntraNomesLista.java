package br.edu.unifaj.cc.poo.aula7;

import java.util.*;

public class EntraNomesLista {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //List<String> nomes = new ArrayList<>();
        List<String> nomes = new LinkedList<>();
        System.out.println("Digite vários nomes.  Vazio para terminar");
        while (true) {
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()) {
                break;
            }
            nomes.add(nome);
        }

        // Ordenar a lista
        Collections.sort(nomes);

        //Exibir os nomes
        for (int i = 0; i < nomes.size(); i++) {
            // get(i) característica da lista
            System.out.println(nomes.get(i));
        }

        System.out.println("Fim do programa");
    }
}
