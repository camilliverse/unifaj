package unifaj.com.planosaude.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import unifaj.com.planosaude.dao.PacienteDAO;
import unifaj.com.planosaude.entity.Paciente;

@Service
public class PacienteService {

    private final PacienteDAO dao = new PacienteDAO();

    public List<Paciente> listarTodos() {
        return dao.listar();
    }

    public Paciente buscarPorId(Long id) {
        Paciente p = dao.buscarPorId(id);
        if (p == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        return p;
    }

    public Paciente cadastrar(Paciente paciente) {
        return dao.inserir(paciente);
    }

    public Paciente atualizar(Long id, Paciente paciente) {
        paciente.setId(id);
        if (!dao.atualizar(paciente)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
        return paciente;
    }

    public void remover(Long id) {
        if (!dao.excluir(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado");
        }
    }
}