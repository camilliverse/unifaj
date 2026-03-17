package br.edu.unifaj.cc.poo.aula05;

public class CDItem {
    private String nome;
    private int id;
    private String observacao;
    private String estado;

    public CDItem(){

    }

    public CDItem(String nome, int id, String observacao, String estado) {
        this.nome = nome;
        this.id = id;
        this.observacao = observacao;
        this.estado = estado;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
