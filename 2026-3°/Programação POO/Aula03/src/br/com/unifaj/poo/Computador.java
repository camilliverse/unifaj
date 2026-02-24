package br.com.unifaj.poo;

public class Computador {

    String cpu;
    int memoria;
    int ssd;
    boolean ligado;

    void ligar(){

        if(ligado){
            System.out.println("Já estava ligado: "+ cpu);
        }else{
            ligado =true;
            System.out.println("Computador "+ cpu + " ligado");

        } //fim do ligar

    }
} //fim da class
