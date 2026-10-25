package unifaj.com.planosaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import unifaj.com.planosaude.entity.Paciente;
import unifaj.com.planosaude.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente cadastrar(@Valid @RequestBody Paciente paciente) {
        return pacienteService.cadastrar(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return pacienteService.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        pacienteService.remover(id);
    }
}