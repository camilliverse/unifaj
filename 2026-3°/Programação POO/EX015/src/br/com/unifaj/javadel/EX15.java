package br.com.unifaj.javadel;

import java.util.Scanner;

public class EX15 {
    static void main(String[] args) {
        System.out.println("Exercicio 15 | RA - 12529495 | Camilli dos Santos ");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = input.nextInt();

        System.out.print("Enter second integer: ");
        int b = input.nextInt();

        System.out.printf("Sum is %d%n", a + b);
        System.out.printf("Product is %d%n", a * b);
        System.out.printf("Difference is %d%n", a - b);
        System.out.printf("Quotient is %d%n", a / b);

        input.close();
    }
}
