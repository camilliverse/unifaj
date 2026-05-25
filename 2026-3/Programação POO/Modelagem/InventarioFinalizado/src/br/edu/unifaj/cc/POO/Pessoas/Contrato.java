package br.edu.unifaj.cc.POO.Pessoas;

import br.edu.unifaj.cc.POO.Relatorios.Relatorio;

public class Contrato implements Relatorio {
    private String numero;
    private String dataInicio;
    private String dataFim;
    private String campanha;
    private double valor;
    private Cliente cliente;
    private Funcionario funcionario;

    public Contrato(String numero, String dataInicio, String dataFim, double valor, Cliente cliente, Funcionario funcionario) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.campanha = campanha;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public void renovarContrato() {
        System.out.println("Contrato renovado");
    }

    @Override
    public String gerarRelatorio() {
        return "Contrato: " + numero +
                " | Cliente: " + cliente.getNome() +
                " | Funcionário: " + funcionario.getNome() +
                " | Valor: " + valor;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}