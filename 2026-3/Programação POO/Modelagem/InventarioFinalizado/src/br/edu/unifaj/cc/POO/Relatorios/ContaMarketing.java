package br.edu.unifaj.cc.POO.Relatorios;

import br.edu.unifaj.cc.POO.Pessoas.Cliente;
import br.edu.unifaj.cc.POO.Pessoas.Funcionario;

public class ContaMarketing implements Relatorio {
    private String idConta;
    private String plataforma;
    private double orcamento;
    private Cliente cliente;
    private Funcionario funcionario;

    public ContaMarketing(String idConta, String plataforma, double orcamento, String campanhaVerão, Cliente cliente, Funcionario funcionario) {
        this.idConta = idConta;
        this.plataforma = plataforma;
        this.orcamento = orcamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public void publicarCampanha() {
        System.out.println("Campanha publicada");
    }

    @Override
    public String gerarRelatorio() {
        return "Conta Marketing: " + idConta +
                " | Plataforma: " + plataforma +
                " | Cliente: " + cliente.getNome() +
                " | Funcionário: " + funcionario.getNome() +
                " | Orçamento: " + orcamento;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}