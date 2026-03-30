package br.com.edu.unifaj.poo;

public class cdItem extends itemBase {
    private String cantor;
    private int numTrilhas;

    public cdItem() {
    }

    public cdItem(int id, String name, String observacao, String estado, int anoDeLancamento, String cantor, int numTrilhas) {
        super(id, name, observacao, estado, anoDeLancamento);
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
