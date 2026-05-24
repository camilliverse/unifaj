package br.com.unifaj.javadel;

import java.util.Scanner;

public class EX26 {
    static void main(String[] args) {
        System.out.println("Exercicio 26 | RA - 12529495 | Camilli dos Santos ");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = input.nextInt();

        System.out.print("Enter second integer: ");
        int b = input.nextInt();

        if (a % b == 0)
            System.out.printf("%d is a multiple of %d%n", a, b);

        if (a % b != 0)
            System.out.printf("%d is not a multiple of %d%n", a, b);

        input.close();
    }
}
