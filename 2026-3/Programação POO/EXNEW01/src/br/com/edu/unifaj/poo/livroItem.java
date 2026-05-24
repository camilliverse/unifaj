package br.com.edu.unifaj.poo;

public class livroItem extends itemBase {
    private String escritor;

    public livroItem() {
    }

    public livroItem(String escritor) {
        this.escritor = escritor;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }
}
