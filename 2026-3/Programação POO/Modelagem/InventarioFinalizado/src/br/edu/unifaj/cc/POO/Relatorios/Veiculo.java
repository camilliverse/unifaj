package br.edu.unifaj.cc.POO.Relatorios;

public class Veiculo extends ItemInventario {
    private String placa;
    private int anoFabricacao;

    public Veiculo(String codigo, String descricao, double valorEstimado, String placa, int anoFabricacao) {
        super(codigo, descricao, valorEstimado);
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    @Override
    public int calcularCargaHoraria() {
        return 0;
    }

    @Override
    public String gerarRelatorio() {
        return "Veículo: " + descricao +
                " | Placa: " + placa +
                " | Ano: " + anoFabricacao +
                " | Valor: " + valorEstimado;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}