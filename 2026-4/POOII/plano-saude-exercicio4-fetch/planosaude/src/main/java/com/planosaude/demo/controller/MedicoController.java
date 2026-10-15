package com.planosaude.demo.controller;

import com.planosaude.demo.model.Medico;
import com.planosaude.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*") // libera o Fetch vindo das paginas HTML
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    // LISTAR
    @GetMapping
    public List<Medico> listar() {
        return medicoService.listar();
    }

    // BUSCAR POR ID (usado na tela de Alterar/Excluir para pre-carregar os dados)
    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // INCLUIR
    @PostMapping
    public ResponseEntity<Medico> incluir(@RequestBody Medico medico) {
        Medico salvo = medicoService.incluir(medico);
        return ResponseEntity.ok(salvo);
    }

    // ALTERAR
    @PutMapping("/{id}")
    public ResponseEntity<Medico> alterar(@PathVariable Long id, @RequestBody Medico medico) {
        Medico atualizado = medicoService.alterar(id, medico);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = medicoService.excluir(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
