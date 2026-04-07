package br.edu.unifaj.cc.poo.aula5;

import java.util.Date;

public class UtilizaItens {

    public static void main(String[] args) {
        CDItem cd1 = new CDItem(1, "Metalica S&M",
                "Show leve e cultural", "Emprestado",
                new Date(1999, 1, 1),
                "Metalica", 20);

        System.out.println("CD" + cd1.getNome());
    }
}
