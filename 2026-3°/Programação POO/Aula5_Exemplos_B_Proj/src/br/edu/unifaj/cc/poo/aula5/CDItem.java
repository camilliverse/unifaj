package br.edu.unifaj.cc.poo.aula5;

import java.util.Date;

public class CDItem extends ItemBase {
    private String cantor;
    private int numTrilhas;

    public CDItem() {
    }

    public CDItem(Integer id, String nome, String observacao, String estado, Date anoLancamento, String cantor, int numTrilhas) {
        super(id, nome, observacao, estado, anoLancamento);
        this.cantor = cantor;
        this.numTrilhas = numTrilhas;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getNumTrilhas() {
        return numTrilhas;
    }

    public void setNumTrilhas(int numTrilhas) {
        this.numTrilhas = numTrilhas;
    }
}
