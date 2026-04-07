package br.edu.unifaj.cc.poo.aula5;

import java.util.Date;

public class ItemBase {

    private Integer id;
    private String nome;
    private String observacao;
    private String estado;
    private Date anoLancamento;

    public ItemBase() {
    }

    public ItemBase(Integer id, String nome, String observacao, String estado, Date anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.observacao = observacao;
        this.estado = estado;
        this.anoLancamento = anoLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Date getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
