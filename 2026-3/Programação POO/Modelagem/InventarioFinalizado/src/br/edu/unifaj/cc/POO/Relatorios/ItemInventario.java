package br.edu.unifaj.cc.POO.Relatorios;

public abstract class ItemInventario implements Relatorio {
    protected String codigo;
    protected String descricao;
    protected double valorEstimado;

    public ItemInventario(String codigo, String descricao, double valorEstimado) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorEstimado = valorEstimado;
    }

    public abstract int calcularCargaHoraria();

    public String getDescricao() {
        return descricao;
    }
}