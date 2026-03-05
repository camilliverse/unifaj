package br.edu.unifaj.poo.computadormenu;

import br.edu.unifaj.poo.computadormenu.Computador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuComputador {

    // A lista deve estar dentro da classe, mas fora dos métodos
    List<Computador> lista = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Iniciando o cadastro de computador");
        MenuComputador menu = new MenuComputador();
        menu.menu();
        System.out.println("Fim do cadastro de computador");
    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1 - Listar 
                    2 - Incluir
                    3 - Excluir 
                    4 - Sair
                    Opção:""");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: listar();
                    break;
                case 2: incluir(sc);
                    break;
                case 3: excluir();
                    break;
                case 4:
                    return;
                default: System.out.println("Opção inválida");
            }
        }
    }

    private void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Excluir um computador: ");
        System.out.println("CPU: ");
        String cpu = sc.nextLine();
        for(int i = 0; i <lista.size(); i++){
            Computador c = lista.get(i);
            if (c.cpu.equalsIgnoreCase(cpu)){
                lista.remove(c);
                System.out.println("Computador excluido com sucesso");
                return;
            }
        }
    }

    private void listar() {
        if (lista.isEmpty()) {
            System.out.println("Nenhum computador cadastrado.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            Computador c = lista.get(i); // Corrigido de .got(1) para .get(i)
            System.out.println("Computador " + (i + 1) + ":");
            System.out.println("Computador: "
                    + " CPU:" + c.cpu
                    + " Memoria:" + c.memoria
                    + " SSD:" + c.ssd
                    + " Ligado:" + c.ligado
                    + " Preço:" + c.preco);

        }
    }
    private void incluir(Scanner sc) {
        System.out.println("Incluir um novo computador:");
        System.out.print("CPU: ");
        String cpu = sc.nextLine();
        System.out.print("Memória: ");
        int memoria = sc.nextInt();
        System.out.print("SSD: ");
        int ssd = sc.nextInt();
        System.out.print("Ligado (true/false): ");
        boolean ligado = sc.nextBoolean();
        System.out.print("Preço: ");
        float preco = sc.nextFloat();
        sc.nextLine();

        // Criando e ADICIONANDO na lista
        Computador c = new Computador(cpu, memoria, ssd, ligado, preco);
        lista.add(c);
        System.out.println("Computador cadastrado com sucesso!");
    }
}