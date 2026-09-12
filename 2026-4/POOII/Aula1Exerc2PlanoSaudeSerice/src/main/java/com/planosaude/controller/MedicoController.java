package com.planosaude.controller;

import com.planosaude.model.Medico;
import com.planosaude.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST da entidade Medico.
 *
 * GET    /api/planosaude/medico            -> obter todos
 * GET    /api/planosaude/medico/{idMedico} -> obter um
 * POST   /api/planosaude/medico            -> criar
 * PUT    /api/planosaude/medico            -> atualizar (id vem no corpo)
 * DELETE /api/planosaude/medico/{idMedico} -> excluir
 */
@RestController
@RequestMapping("/api/planosaude/medico")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    // Obter todos
    @GetMapping
    public List<Medico> obterTodos() {
        return medicoRepository.findAll();
    }

    // Obter um
    @GetMapping("/{idMedico}")
    public ResponseEntity<Medico> obterUm(@PathVariable Long idMedico) {
        return medicoRepository.findById(idMedico)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar
    @PostMapping
    public ResponseEntity<Medico> criar(@Valid @RequestBody Medico medico) {
        medico.setId(null); // garante que sera um registro novo
        Medico salvo = medicoRepository.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Atualizar
    @PutMapping
    public ResponseEntity<Medico> atualizar(@Valid @RequestBody Medico medico) {
        if (medico.getId() == null || !medicoRepository.existsById(medico.getId())) {
            return ResponseEntity.notFound().build();
        }
        Medico atualizado = medicoRepository.save(medico);
        return ResponseEntity.ok(atualizado);
    }

    // Excluir
    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Void> excluir(@PathVariable Long idMedico) {
        if (!medicoRepository.existsById(idMedico)) {
            return ResponseEntity.notFound().build();
        }
        medicoRepository.deleteById(idMedico);
        return ResponseEntity.noContent().build();
    }
}
