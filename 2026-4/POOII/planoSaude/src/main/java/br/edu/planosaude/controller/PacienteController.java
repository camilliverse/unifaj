package br.edu.planosaude.controller;

import br.edu.planosaude.dao.PacienteDAO;
import br.edu.planosaude.model.Paciente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteDAO dao;

    public PacienteController(PacienteDAO dao) { this.dao = dao; }

    @GetMapping
    public List<Paciente> listar() { return dao.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente obj = dao.buscar(id);
        return obj == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(obj);
    }

    @PostMapping
    public Paciente incluir(@RequestBody Paciente obj) { return dao.incluir(obj); }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> alterar(@PathVariable Long id, @RequestBody Paciente obj) {
        if (dao.buscar(id) == null) return ResponseEntity.notFound().build();
        obj.setId(id);
        return ResponseEntity.ok(dao.alterar(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return dao.excluir(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
