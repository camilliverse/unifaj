package com.planosaude.demo.controller;

import com.planosaude.demo.model.Paciente;
import com.planosaude.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*") // libera o Fetch vindo das paginas HTML
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // LISTAR
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // INCLUIR
    @PostMapping
    public ResponseEntity<Paciente> incluir(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.incluir(paciente);
        return ResponseEntity.ok(salvo);
    }

    // ALTERAR
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> alterar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente atualizado = pacienteService.alterar(id, paciente);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = pacienteService.excluir(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
