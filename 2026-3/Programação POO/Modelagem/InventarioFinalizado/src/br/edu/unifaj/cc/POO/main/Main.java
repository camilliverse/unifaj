package br.edu.unifaj.cc.POO.main;

import br.edu.unifaj.cc.POO.Pessoas.Cliente;
import br.edu.unifaj.cc.POO.Pessoas.Contrato;
import br.edu.unifaj.cc.POO.Pessoas.Funcionario;
import br.edu.unifaj.cc.POO.Relatorios.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("RA: ");
        String ra = input.nextLine();

        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = input.nextLine();


        System.out.print("Email: ");
        String email = input.nextLine();

        while (!email.matches(".+@.+\\.com")) {
            System.out.print("Email inválido: ");
            email = input.nextLine();
        }

        System.out.print("Matrícula (F000): ");
        String matricula = input.nextLine();

        while (!matricula.matches("F\\d{3}")) {
            System.out.print("Matrícula inválida: ");
            matricula = input.nextLine();
        }

        System.out.print("Cargo: ");
        String cargo = input.nextLine();

        System.out.print("Salário: ");
        double salario = input.nextDouble();
        input.nextLine();

        Funcionario funcionario = new Funcionario(1, nomeFuncionario, email, matricula, cargo, salario, ra);

        System.out.print("Nome do cliente: ");
        String nomeCliente = input.nextLine();

        System.out.print("CPF/CNPJ (somente números): ");
        String documento = input.nextLine();

        while (!documento.matches("\\d{11}|\\d{14}")) {
            System.out.print("Documento inválido: ");
            documento = input.nextLine();
        }

        System.out.print("Empresa: ");
        String empresa = input.nextLine();

        System.out.print("Segmento: ");
        String segmento = input.nextLine();

        Cliente cliente = new Cliente(2, nomeCliente, "cliente@email.com", documento, empresa, segmento);

        Equipamento equipamento = new Equipamento("EQ001", "Notebook", 4500.0, "Dell", "G15", "123ABC");

        Veiculo veiculo = new Veiculo("VH001", "Carro da empresa", 70000.0, "ABC1D23", 2024);

        Contrato contrato = new Contrato("CO001", "01/01/2026", "01/01/2027", 10000.0, cliente, funcionario);

        ContaMarketing conta = new ContaMarketing("CT001", "Instagram", 3000.0, "Campanha Verão", cliente, funcionario);

        AlocacaoItem alocacao1 = new AlocacaoItem("20/05/2026", "Notebook principal", funcionario, equipamento);

        AlocacaoItem alocacao2 = new AlocacaoItem("21/05/2026", "Veículo de visitas", funcionario, veiculo);

        RelatorioGeral relatorio = new RelatorioGeral();

        relatorio.adicionarItem(funcionario.gerarRelatorio());
        relatorio.adicionarItem(cliente.gerarRelatorio());
        relatorio.adicionarItem(equipamento.gerarRelatorio());
        relatorio.adicionarItem(veiculo.gerarRelatorio());
        relatorio.adicionarItem(contrato.gerarRelatorio());
        relatorio.adicionarItem(conta.gerarRelatorio());
        relatorio.adicionarItem(alocacao1.gerarRelatorio());
        relatorio.adicionarItem(alocacao2.gerarRelatorio());

        System.out.println("\nRA: " + funcionario.getRa());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println();

        relatorio.exibirTodos();

        String json = "{\n" +
                "  \"funcionario\": {\n" +
                "    \"ra\": \"" + funcionario.getRa() + "\",\n" +
                "    \"nome\": \"" + funcionario.getNome() + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"matricula\": \"" + matricula + "\",\n" +
                "    \"cargo\": \"" + cargo + "\",\n" +
                "    \"salario\": \"" + salario + "\"\n" +
                "  },\n" +

                "  \"cliente\": {\n" +
                "    \"nome\": \"" + nomeCliente + "\",\n" +
                "    \"documento\": \"" + documento + "\",\n" +
                "    \"empresa\": \"" + empresa + "\",\n" +
                "    \"segmento\": \"" + segmento + "\"\n" +
                "  }\n" +
                "}";

        GeradorJSON.gerar(json);

    }
}
