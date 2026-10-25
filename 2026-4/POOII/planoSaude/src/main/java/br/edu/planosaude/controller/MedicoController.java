package br.edu.planosaude.controller;

import br.edu.planosaude.dao.MedicoDAO;
import br.edu.planosaude.model.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoDAO dao;

    public MedicoController(MedicoDAO dao) { this.dao = dao; }

    @GetMapping
    public List<Medico> listar() { return dao.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Long id) {
        Medico obj = dao.buscar(id);
        return obj == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(obj);
    }

    @PostMapping
    public Medico incluir(@RequestBody Medico obj) { return dao.incluir(obj); }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> alterar(@PathVariable Long id, @RequestBody Medico obj) {
        if (dao.buscar(id) == null) return ResponseEntity.notFound().build();
        obj.setId(id);
        return ResponseEntity.ok(dao.alterar(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        return dao.excluir(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
