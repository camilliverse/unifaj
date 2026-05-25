package br.edu.unifaj.cc.POO.Relatorios;

public class Equipamento extends ItemInventario {
    private String marca;
    private String modelo;
    private String numeroSerie;

    public Equipamento(String codigo, String descricao, double valorEstimado, String marca, String modelo, String numeroSerie) {
        super(codigo, descricao, valorEstimado);
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
    }

    public void registrarManutencao() {
        System.out.println("Manutenção registrada");
    }

    @Override
    public int calcularCargaHoraria() {
        return 0;
    }

    @Override
    public String gerarRelatorio() {
        return "Equipamento: " + descricao +
                " | Marca: " + marca +
                " | Modelo: " + modelo +
                " | Série: " + numeroSerie +
                " | Valor: " + valorEstimado;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}