package br.edu.unifaj.cc.poo.aula5.report;

import br.edu.unifaj.cc.poo.aula5.arrow.Execute;

import java.util.*;

public class PagamentoRelatorio extends Relatorio {



    @Override
    public String getTitulo() {
        return "Relatorio de Pagamento de vendas";
    }

    @Override
    public List<Map<String, String>> getDados() {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> m1 = new TreeMap<>();
        m1.put("Cliente", "Maria");
        m1.put("Data", "30/03/2026");
        m1.put("Valor", "R$ 200,00");
        list.add(m1);

        Map<String, String> m2 = new TreeMap<>();
        m2.put("Cliente", "Gabriella");
        m2.put("Data", "30/03/2026");
        m2.put("Valor", "R$ 250,00");
        list.add(m2);

        return list;




    }


}
