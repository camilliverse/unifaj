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
import unifaj.com.planosaude.entity.Medico;
import unifaj.com.planosaude.service.MedicoService;

@RestController
@RequestMapping("/medicos")
@CrossOrigin
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico cadastrar(@Valid @RequestBody Medico medico) {
        return medicoService.cadastrar(medico);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id, @Valid @RequestBody Medico medico) {
        return medicoService.atualizar(id, medico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        medicoService.remover(id);
    }
}