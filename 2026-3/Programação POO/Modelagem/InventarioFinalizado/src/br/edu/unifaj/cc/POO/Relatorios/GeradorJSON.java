package br.edu.unifaj.cc.POO.Relatorios;


import java.io.FileWriter;
import java.io.IOException;

public class GeradorJSON {

    public static void gerar(String json) {

        try {

            FileWriter writer = new FileWriter("relatorio.json");

            writer.write(json);

            writer.close();

            System.out.println("JSON gerado com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao gerar JSON.");

        }
    }
}