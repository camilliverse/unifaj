package br.edu.unifaj.cc.poo.aula7;

import java.util.Objects;
import java.util.Scanner;

public class Carro implements Comparable<Carro> {
    private String placa;
    private String cor;
    private String modelo;

    @Override
    public int hashCode() {
        return Objects.hash(placa, cor, modelo);
    }


    @Override
    public int compareTo(Carro o) {
        int ret = this.placa.compareTo(o.placa);
//        if (ret == 0) {
//            ret = this.cor.compareTo(o.cor);
//            if (ret == 0) {
//                ret = this.modelo.compareTo(o.modelo);
//            }
//        }
        return ret;
    }

    @Override
    public String toString() {
        return "Carro " + this.placa + " " + this.cor + " " + this.modelo;
    }

    public static Carro entrar(Scanner sc) {
        Carro carro = new Carro();
        System.out.println("Entre com o Placa: ");
        carro.placa = sc.nextLine();
        if (carro.placa.trim().isEmpty()) {
            return null;
        }
        System.out.println("Entre com o Cor: ");
        carro.cor = sc.nextLine();
        if (carro.cor.trim().isEmpty()) {
            return null;
        }
        System.out.println("Entre com o Modelo: ");
        carro.modelo = sc.nextLine();
        if (carro.modelo.trim().isEmpty()) {
            return null;
        }
        return carro;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
