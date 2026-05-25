package br.edu.unifaj.cc.POO.Pessoas;

public class Cliente extends Pessoa {
    private String cnpjCpf;
    private String empresa;
    private String segmento;

    public Cliente(int id, String nome, String email, String cnpjCpf, String empresa, String segmento) {
        super(id, nome, email);
        this.cnpjCpf = cnpjCpf;
        this.empresa = empresa;
        this.segmento = segmento;
    }

    @Override
    public int calcularCargaHoraria() {
        return 0;
    }

    public String consultarHistorico() {
        return "Histórico do cliente disponível";
    }

    @Override
    public String gerarRelatorio() {
        return "Cliente: " + nome +
                " | Documento: " + cnpjCpf +
                " | Empresa: " + empresa +
                " | Segmento: " + segmento;
    }

    @Override
    public void exibirInfo() {
        System.out.println(gerarRelatorio());
    }
}