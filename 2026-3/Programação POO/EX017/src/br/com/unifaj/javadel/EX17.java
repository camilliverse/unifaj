package br.com.unifaj.javadel;

import java.util.Scanner;

public class EX17 {
    static void main(String[] args) {
        System.out.println("Exercicio 17 | RA - 12529495 | Camilli dos Santos ");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = input.nextInt();

        System.out.print("Enter second integer: ");
        int b = input.nextInt();

        System.out.print("Enter third integer: ");
        int c = input.nextInt();

        int sum = a + b + c;
        int average = sum / 3;
        int product = a * b * c;

        int menor = a;
        if (b < menor)
            menor = b;
        if (c < menor)
            menor = c;

        int maior = a;
        if (b > maior)
            maior = b;
        if (c > maior)
            maior = c;

        System.out.printf("Sum is %d%n", sum);
        System.out.printf("Average is %d%n", average);
        System.out.printf("Product is %d%n", product);
        System.out.printf("Smallest is %d%n", menor);
        System.out.printf("Largest is %d%n", maior);

        input.close();

    }
}
