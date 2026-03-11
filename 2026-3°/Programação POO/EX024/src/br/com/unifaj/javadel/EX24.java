package br.com.unifaj.javadel;

import java.util.Scanner;

public class EX24 {
    static void main(String[] args) {
        System.out.println("Exercicio 24 | RA - 12529495 | Camilli dos Santos ");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int n1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int n2 = input.nextInt();
        System.out.print("Enter third integer: ");
        int n3 = input.nextInt();
        System.out.print("Enter fourth integer: ");
        int n4 = input.nextInt();
        System.out.print("Enter fifth integer: ");
        int n5 = input.nextInt();

        int maior = n1;
        if (n2 > maior) maior = n2;
        if (n3 > maior) maior = n3;
        if (n4 > maior) maior = n4;
        if (n5 > maior) maior = n5;

        int menor = n1;
        if (n2 < menor) menor = n2;
        if (n3 < menor) menor = n3;
        if (n4 < menor) menor = n4;
        if (n5 < menor) menor = n5;

        System.out.printf("Largest: %d%n", maior);
        System.out.printf("Smallest: %d%n", menor);

        input.close();

    }
}
