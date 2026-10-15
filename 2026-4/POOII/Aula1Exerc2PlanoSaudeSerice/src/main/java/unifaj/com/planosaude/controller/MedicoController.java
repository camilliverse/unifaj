package unifaj.com.planosaude.controller;

import unifaj.com.planosaude.entity.Medico;
import unifaj.com.planosaude.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/planosaude/medico")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping
    public List<unifaj.com.planosaude.entity.Medico> obterTodos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/{idMedico}")
    public ResponseEntity<unifaj.com.planosaude.entity.Medico> obterUm(@PathVariable Long idMedico) {
        return medicoRepository.findById(idMedico)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Medico> criar(@Valid @RequestBody Medico medico) {
        medico.setId(null);

        Medico salvo = medicoRepository.save(medico);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }

    @PutMapping
    public ResponseEntity<Medico> atualizar(@Valid @RequestBody Medico medico) {
        if (medico.getId() == null || !medicoRepository.existsById(medico.getId())) {
            return ResponseEntity.notFound().build();
        }

        Medico atualizado = medicoRepository.save(medico);

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idMedico}")
    public ResponseEntity<Void> excluir(@PathVariable Long idMedico) {
        if (!medicoRepository.existsById(idMedico)) {
            return ResponseEntity.notFound().build();
        }
        medicoRepository.deleteById(idMedico);
        return ResponseEntity.noContent().build();
    }
}
