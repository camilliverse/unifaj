package unifaj.com.planoSaude.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.com.planoSaude.entity.Paciente;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final unifaj.com.planoSaude.dao.PacienteDAO pacienteDAO;

    public Paciente cadastrar(Paciente paciente) {
        return pacienteDAO.save(paciente);
    }

    public List<Paciente> listar() {
        return pacienteDAO.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteDAO.findById(id).orElse(null);
    }

    public void remover(Long id) {
        pacienteDAO.deleteById(id);
    }
}