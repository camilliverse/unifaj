package br.com.unifaj.poo;

import java.util.Scanner;

public class VetorDeNomes {
    public static void main(String[] args) {
        System.out.print("Quantidade: ");
        Scanner sc = new Scanner(System.in); // perde o usuario digitar
        int total = sc.nextInt();
        sc  .nextLine();

        String[] nomes = new String[total];
        //Entrada de nomes
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Nome" + (i+1) + ": ");
            nomes[i] = sc.nextLine();
        }
        //Exibir os nomes separadas por virgula
        System.out.print("Os nomes são: ");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print(nomes[i]);
            //Não espaça no ultimo
            if(i < nomes.length -1){
                System.out.print(",");
            }
        }
    }
}
