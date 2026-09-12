package unifaj.com.planosaude.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifaj.com.planosaude.entity.Paciente;
import unifaj.com.planosaude.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api/planosaude/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> obterTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Paciente> obterUm(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(pacienteService.buscarPorId(idPaciente));
    }

    @PostMapping
    public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.cadastrar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizar(@Valid @RequestBody Paciente paciente) {
        if (paciente.getId() == null) {
            throw new IllegalArgumentException("Informe o id do paciente no corpo da requisicao para atualizar.");
        }
        Paciente atualizado = pacienteService.atualizar(paciente.getId(), paciente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idPaciente}")
    public ResponseEntity<Void> excluir(@PathVariable Long idPaciente) {
        pacienteService.remover(idPaciente);
        return ResponseEntity.noContent().build();
    }
}
