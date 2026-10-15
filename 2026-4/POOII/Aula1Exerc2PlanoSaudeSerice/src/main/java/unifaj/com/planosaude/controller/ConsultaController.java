package unifaj.com.planosaude.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifaj.com.planosaude.entity.Consulta;
import unifaj.com.planosaude.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/api/planosaude/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> obterTodas() {
        return ResponseEntity.ok(consultaService.listarTodas());
    }

    @GetMapping("/{idConsulta}")
    public ResponseEntity<Consulta> obterUma(@PathVariable Long idConsulta) {
        return ResponseEntity.ok(consultaService.buscarPorId(idConsulta));
    }

    @PostMapping
    public ResponseEntity<Consulta> criar(
            @Valid @RequestBody Consulta consulta) {

        Consulta salva = consultaService.cadastrar(consulta);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salva);
    }

    @PutMapping
    public ResponseEntity<Consulta> atualizar(
            @Valid @RequestBody Consulta consulta) {

        if (consulta.getId() == null) {
            throw new IllegalArgumentException(
                    "Informe o id da consulta no corpo da requisicao para atualizar."
            );
        }

        Consulta atualizada =
                consultaService.atualizar(consulta.getId(), consulta);

        return ResponseEntity.ok(atualizada);
    }

    @PatchMapping("/{idConsulta}/cancelar")
    public ResponseEntity<Consulta> cancelar(
            @PathVariable Long idConsulta) {

        return ResponseEntity.ok(
                consultaService.cancelar(idConsulta)
        );
    }

    @DeleteMapping("/{idConsulta}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long idConsulta) {

        consultaService.remover(idConsulta);

        return ResponseEntity.noContent().build();
    }
}