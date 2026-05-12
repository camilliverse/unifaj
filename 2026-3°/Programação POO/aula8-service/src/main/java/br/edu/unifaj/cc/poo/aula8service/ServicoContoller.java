package br.edu.unifaj.cc.poo.aula8service;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Recebe as informações da WEB
@RestController
@RequestMapping("/api")
public class ServicoContoller {

    private Map<Integer, Servico> servicos = new TreeMap<>();

    public ServicoContoller() {
        Servico s1 = new Servico(1, "Baleias Orcas", "Aquario - Delicia Negra" , 85.45);
        Servico s2 = new Servico(2, "Cavalo-Marinho", "Aquario - Delicia Negra" , 22.90);

        servicos.put(s1.getId(), s1);
        servicos.put(s2.getId(), s2);
    }

    @GetMapping("/servico")
    public List<Servico> getServicos() {
        return new ArrayList<>(servicos.values());
    }

    @GetMapping("/servico/{id}")
    public Servico getServico(@PathVariable Integer id) {
        return servicos.get(id);
    }

    @PostMapping("/servico")
    public Servico postServico(@RequestBody Servico servico) {
        return servicos.put(servico.getId(), servico);
    }

    @GetMapping("/test")
    public String teste(){
        return "Que FRIOOO";
    }
}
