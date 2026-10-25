package br.com.planosaude.service;

import br.com.planosaude.dao.PacienteDAO;
import br.com.planosaude.model.Paciente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteService {

    private final PacienteDAO dao = new PacienteDAO();

    @GetMapping
    public List<Paciente> listar() {
        return dao.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable long id) {
        Paciente p = dao.buscarPorId(id);
        if (p == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente nao encontrado");
        return p;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente incluir(@RequestBody Paciente p) {
        return dao.inserir(p);
    }

    @PutMapping("/{id}")
    public Paciente alterar(@PathVariable long id, @RequestBody Paciente p) {
        p.setId(id);
        if (!dao.atualizar(p)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente nao encontrado");
        return p;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable long id) {
        if (!dao.excluir(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente nao encontrado");
    }
}
