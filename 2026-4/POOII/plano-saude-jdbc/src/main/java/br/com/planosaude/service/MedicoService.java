package br.com.planosaude.service;

import br.com.planosaude.dao.MedicoDAO;
import br.com.planosaude.model.Medico;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin
public class MedicoService {

    private final MedicoDAO dao = new MedicoDAO();

    @GetMapping
    public List<Medico> listar() {
        return dao.listar();
    }

    @GetMapping("/{id}")
    public Medico buscar(@PathVariable long id) {
        Medico m = dao.buscarPorId(id);
        if (m == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico nao encontrado");
        return m;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico incluir(@RequestBody Medico m) {
        return dao.inserir(m);
    }

    @PutMapping("/{id}")
    public Medico alterar(@PathVariable long id, @RequestBody Medico m) {
        m.setId(id);
        if (!dao.atualizar(m)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico nao encontrado");
        return m;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable long id) {
        if (!dao.excluir(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medico nao encontrado");
    }
}
