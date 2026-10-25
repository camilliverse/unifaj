package unifaj.com.planosaude.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import unifaj.com.planosaude.dao.MedicoDAO;
import unifaj.com.planosaude.entity.Medico;

@Service
public class MedicoService {

    private final MedicoDAO dao = new MedicoDAO();

    public List<Medico> listarTodos() {
        return dao.listar();
    }

    public Medico buscarPorId(Long id) {
        Medico m = dao.buscarPorId(id);
        if (m == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }
        return m;
    }

    public Medico cadastrar(Medico medico) {
        return dao.inserir(medico);
    }

    public Medico atualizar(Long id, Medico medico) {
        medico.setId(id);
        if (!dao.atualizar(medico)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }
        return medico;
    }

    public void remover(Long id) {
        if (!dao.excluir(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado");
        }
    }
}