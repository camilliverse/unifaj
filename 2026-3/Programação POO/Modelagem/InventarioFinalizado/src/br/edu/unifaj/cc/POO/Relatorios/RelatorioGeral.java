package br.edu.unifaj.cc.POO.Relatorios;

import java.util.ArrayList;
import java.util.List;

public class RelatorioGeral {
    private List<String> listaRelatorios;

    public RelatorioGeral() {
        listaRelatorios = new ArrayList<>();
    }

    public void adicionarItem(String relatorio) {
        listaRelatorios.add(relatorio);
    }

    public void exibirTodos() {
        for (String relatorio : listaRelatorios) {
            System.out.println(relatorio);
        }
    }
}