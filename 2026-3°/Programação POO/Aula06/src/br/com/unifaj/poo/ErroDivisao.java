package br.com.unifaj.poo;

import java.util.Scanner;

public class ErroDivisao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        System.out.print("Digite números a serem divididos: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        float divisao =  num1 / num2;
        System.out.println("Resultado: " + divisao);

        }catch(Exception ex) {
            System.out.println("Erro ao dividir");
        }finally{
            sc.close();
            System.out.println("Programa finalizado");
        }
    }
}
