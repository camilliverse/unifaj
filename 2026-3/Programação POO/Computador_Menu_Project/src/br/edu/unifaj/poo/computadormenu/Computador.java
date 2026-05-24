package br.edu.unifaj.poo.computadormenu;

public class Computador {

    String cpu;
    int memoria;
    int ssd;
    boolean ligado;
    float preco;

    //Construtor padrao
    public Computador(){

    }

    public Computador(String cpu,int sdd,int memoria, boolean ligado, float preco){
        this.cpu = cpu;
        this.memoria = memoria;
        this.ssd = sdd;
        this.memoria = memoria;
        this.ligado = ligado;
        this.preco = preco;

    }

}
