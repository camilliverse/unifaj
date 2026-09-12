package com.planosaude.controller;

import com.planosaude.model.Beneficiario;
import com.planosaude.repository.BeneficiarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST da entidade Beneficiario.
 *
 * GET    /api/planosaude/beneficiario                  -> obter todos
 * GET    /api/planosaude/beneficiario/{idBeneficiario} -> obter um
 * POST   /api/planosaude/beneficiario                  -> criar
 * PUT    /api/planosaude/beneficiario                  -> atualizar (id vem no corpo)
 * DELETE /api/planosaude/beneficiario/{idBeneficiario} -> excluir
 */
@RestController
@RequestMapping("/api/planosaude/beneficiario")
public class BeneficiarioController {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioController(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    // Obter todos
    @GetMapping
    public List<Beneficiario> obterTodos() {
        return beneficiarioRepository.findAll();
    }

    // Obter um
    @GetMapping("/{idBeneficiario}")
    public ResponseEntity<Beneficiario> obterUm(@PathVariable Long idBeneficiario) {
        return beneficiarioRepository.findById(idBeneficiario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar
    @PostMapping
    public ResponseEntity<Beneficiario> criar(@Valid @RequestBody Beneficiario beneficiario) {
        beneficiario.setId(null); // garante que sera um registro novo
        Beneficiario salvo = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Atualizar
    @PutMapping
    public ResponseEntity<Beneficiario> atualizar(@Valid @RequestBody Beneficiario beneficiario) {
        if (beneficiario.getId() == null || !beneficiarioRepository.existsById(beneficiario.getId())) {
            return ResponseEntity.notFound().build();
        }
        Beneficiario atualizado = beneficiarioRepository.save(beneficiario);
        return ResponseEntity.ok(atualizado);
    }

    // Excluir
    @DeleteMapping("/{idBeneficiario}")
    public ResponseEntity<Void> excluir(@PathVariable Long idBeneficiario) {
        if (!beneficiarioRepository.existsById(idBeneficiario)) {
            return ResponseEntity.notFound().build();
        }
        beneficiarioRepository.deleteById(idBeneficiario);
        return ResponseEntity.noContent().build();
    }
}
