package unifaj.com.planosaude.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.com.planosaude.entity.Consulta;
import unifaj.com.planosaude.exception.ResourceNotFoundException;
import unifaj.com.planosaude.repository.ConsultaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Consulta nao encontrada com id: " + id));
    }

    public Consulta cadastrar(Consulta consulta) {
        consulta.setId(null);
        consulta.agendar();
        return consultaRepository.save(consulta);
    }

    public Consulta atualizar(Long id, Consulta dadosAtualizados) {
        Consulta existente = buscarPorId(id);

        existente.setData(dadosAtualizados.getData());
        existente.setHorario(dadosAtualizados.getHorario());
        existente.setPaciente(dadosAtualizados.getPaciente());
        existente.setMedico(dadosAtualizados.getMedico());

        if (dadosAtualizados.getStatus() != null) {
            existente.setStatus(dadosAtualizados.getStatus());
        }

        return consultaRepository.save(existente);
    }

    public Consulta cancelar(Long id) {
        Consulta existente = buscarPorId(id);
        existente.cancelar();
        return consultaRepository.save(existente);
    }

    public void remover(Long id) {
        consultaRepository.delete(buscarPorId(id));
    }
}