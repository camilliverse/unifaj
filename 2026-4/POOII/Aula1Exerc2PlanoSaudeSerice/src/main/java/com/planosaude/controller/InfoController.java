package com.planosaude.controller;

import com.planosaude.Aula1Exerc2PlanoSaudeSericeApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Endpoint simples so para exibir o RA e o Nome do aluno responsavel pelo projeto.
 * GET /api/planosaude/info
 */
@RestController
@RequestMapping("/api/planosaude/info")
public class InfoController {

    @GetMapping
    public Map<String, String> info() {
        Map<String, String> dados = new LinkedHashMap<>();
        dados.put("projeto", "Aula1Exerc2PlanoSaudeSerice");
        dados.put("ra", Aula1Exerc2PlanoSaudeSericeApplication.RA_ALUNO);
        dados.put("nome", Aula1Exerc2PlanoSaudeSericeApplication.NOME_ALUNO);
        return dados;
    }
}
