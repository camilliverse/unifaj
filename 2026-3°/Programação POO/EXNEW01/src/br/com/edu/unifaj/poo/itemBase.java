package br.com.edu.unifaj.poo;

public class itemBase {
    private int id;
    private String name;
    private String observacao;
    private String estado;
    private int anoDeLancamento;

    public itemBase() {
    }

    public itemBase(int id, String name, String observacao, String estado, int anoDeLancamento) {
        this.id = id;
        this.name = name;
        this.observacao = observacao;
        this.estado = estado;
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getId() {
        return id;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}
