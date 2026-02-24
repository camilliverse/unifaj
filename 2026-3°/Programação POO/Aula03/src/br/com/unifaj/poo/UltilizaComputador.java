package br.com.unifaj.poo;

public class UltilizaComputador {
    public static void main(String[] args) {

        Computador c1 = new Computador(); //Objeto
        c1.cpu = "AMD Ryzen 5600GT";
        c1.memoria =16;
        c1.ssd = 512;
        c1.ligar();

        Computador c2 = new Computador();
        c2.cpu = "Intel core i5 10400F";
        c2.memoria = 32;
        c2.ssd = 1024;
        c2.ligar();
    }
}
