package br.edu.unifaj.cc.poo.aula5.report;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class Relatorio {

    public void salvarXLSX(){
        String str = getTitulo();
        str += "\n\n";
        str += "Dados\n";

        for (Map <String, String> p : getDados()) {
            for (String key : p.keySet()) {
                str += key + ": " + p.get(key) + " ";
            }
            str += "\n";
        }
        System.out.println(str);


    }
    public void salvarPDF(){
    }

    public abstract String getTitulo();

    public abstract List<Map <String, String> > getDados();

}
