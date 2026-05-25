package br.edu.unifaj.cc.POO.Relatorios;

import br.edu.unifaj.cc.POO.Pessoas.Funcionario;

public class AlocacaoItem implements Relatorio {
    private String dataAlocacao;
    private String observacao;
    private Funcionario funcionario;
    private ItemInventario item;

    public AlocacaoItem(String dataAlocacao, String observacao, Funcionario funcionario, ItemInventario item) {
        this.dataAlocacao = dataAlocacao;
        this.observacao = observacao;
        this.funcionario = funcionario;
        this.item = item;
    }

    public void registrarAlocacao() {
        System.out.println("Alocação registrada");
    }

    @Override
    public String gerarRelatorio() {
        return "Alocação: " + dataAlocacao +
                " | Funcionário: " + funcionario.getNome() +
                " | Item: " + item.getDescricao() +
                " | Observação: " + observacao;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}