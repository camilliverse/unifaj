package br.com.unifaj.javadel;

import java.util.Scanner;

public class EX25 {
    static void main(String[] args) {
        System.out.println("Exercicio 25 | RA - 12529495 | Camilli dos Santos ");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = input.nextInt();

        if (n % 2 == 0)
            System.out.printf("%d is even%n", n);

        if (n % 2 != 0)
            System.out.printf("%d is odd%n", n);

        input.close();

    }
}
