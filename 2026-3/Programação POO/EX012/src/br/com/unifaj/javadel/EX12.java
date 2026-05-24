package br.com.unifaj.javadel;

public class EX12 {
    static void main(String[] args) {
        System.out.println("Exercicio 12 | RA: 12529495 | Nome: Camilli dos Santos");
        int a = 2, x = 3, y;

        y = a * x * x * x + 7;
        System.out.println("a) y = a * x * x * x + 7         => y = " + y + " (CORRETO)");

        y = a * x * x * (x + 7);
        System.out.println("b) y = a * x * x * (x + 7)        => y = " + y + " (ERRADO)");

        y = (a * x) * x * (x + 7);
        System.out.println("c) y = (a * x) * x * (x + 7)      => y = " + y + " (ERRADO)");

        y = (a * x) * x * x + 7;
        System.out.println("d) y = (a * x) * x * x + 7        => y = " + y + " (CORRETO)");

        y = a * (x * x * x) + 7;
        System.out.println("e) y = a * (x * x * x) + 7        => y = " + y + " (CORRETO)");

        y = a * x * (x * x + 7);
        System.out.println("f) y = a * x * (x * x + 7)        => y = " + y + " (ERRADO)");
    }
}
