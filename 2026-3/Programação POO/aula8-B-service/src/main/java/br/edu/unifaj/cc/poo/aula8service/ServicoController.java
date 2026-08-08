package br.edu.unifaj.cc.poo.aula8service;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api")
public class ServicoController {

    private Map<Integer, Servico> servicos = new TreeMap<>();

    public ServicoController() {
        Servico s1 = new Servico(1, "Expresso", "Café Expresso", 6.0f);
        Servico s2 = new Servico(2, "Pão na Chapa", "Pão na chapa com manteiga", 10.0f);

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
        servicos.put(servico.getId(), servico);
        return servico;
    }

    @PostMapping("/servicoForm")
    public Servico postServicoForm(Servico servico) {
        servicos.put(servico.getId(), servico);
        return servico;
    }

    @PutMapping("/servico")
    public Servico putServico(@RequestBody Servico servico) {
        Servico existente = servicos.get(servico.getId());
        if (existente != null) {
            existente.setValor(servico.getValor());
        }
        return existente;
    }

    @DeleteMapping("/servico/{id}")
    public Servico deleteServico(@PathVariable Integer id) {
        Servico existente = servicos.get(id);
        if (existente != null) {
            servicos.remove(id);
        }
        return existente;
    }

    @GetMapping("/test")
    public String teste() {
        return "Hoje está Frio!!!";
    }
}
