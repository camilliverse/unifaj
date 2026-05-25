package br.edu.unifaj.cc.POO.Pessoas;

import br.edu.unifaj.cc.POO.Relatorios.ItemInventario;

public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;
    private double salario;
    private String ra;

    public Funcionario(int id, String nome, String email, String matricula, String cargo, double salario, String ra) {
        super(id, nome, email);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
        this.ra = ra;
    }

    @Override
    public int calcularCargaHoraria() {
        return 40;
    }

    @Override
    public String gerarRelatorio() {
        return "Funcionário: " + nome +
                " | Matrícula: " + matricula +
                " | Cargo: " + cargo +
                " | Salário: " + salario +
                " | RA: " + ra;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }

    public void alocarItem(ItemInventario item) {
        System.out.println(item.getDescricao() + " alocado para " + nome);
    }

    public String getRa() {
        return ra;
    }
}