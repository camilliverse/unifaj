package br.edu.unifaj.cc.poo.aula5;

import java.util.Date;

public class DVDItem extends ItemBase {
    private String ator;

    public DVDItem() {
    }

    public DVDItem(Integer id, String nome, String observacao, String estado, Date anoLancamento, String ator) {
        super(id, nome, observacao, estado, anoLancamento);
        this.ator = ator;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }
}
