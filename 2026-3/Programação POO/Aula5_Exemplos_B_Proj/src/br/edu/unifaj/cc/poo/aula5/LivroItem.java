package br.edu.unifaj.cc.poo.aula5;

import java.util.Date;

public class LivroItem extends ItemBase {

    private String escrito;

    public LivroItem() {
    }

    public LivroItem(Integer id, String nome, String observacao, String estado, Date anoLancamento, String escrito) {
        super(id, nome, observacao, estado, anoLancamento);
        this.escrito = escrito;
    }

    public String getEscrito() {
        return escrito;
    }

    public void setEscrito(String escrito) {
        this.escrito = escrito;
    }
}
