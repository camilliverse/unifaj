package br.edu.unifaj.cc.poo.aula7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EntraCarrosList {

    public static void main(String[] args) {

        List<Carro> carros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            Carro c = Carro.entrar(sc);
            if (c == null) {
                break;
            }
            carros.add(c);
        }

        Collections.sort(carros);

        for (Carro c : carros) {
            System.out.println(c);
        }
    }

}
