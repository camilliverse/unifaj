package br.com.edu.unifaj.poo;

public class dvdItem extends itemBase  {
    private String ator;

    public dvdItem(String ator) {
        this.ator = ator;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }
}
