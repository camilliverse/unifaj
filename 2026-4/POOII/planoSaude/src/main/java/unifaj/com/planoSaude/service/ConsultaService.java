package unifaj.com.planoSaude.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.com.planoSaude.dao.ConsultaDAO;
import unifaj.com.planoSaude.entity.Consulta;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaDAO consultaDAO;

    public Consulta cadastrar(Consulta consulta) {
        return consultaDAO.save(consulta);
    }

    public List<Consulta> listar() {
        return consultaDAO.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaDAO.findById(id).orElse(null);
    }

    public void remover(Long id) {
        consultaDAO.deleteById(id);
    }
}