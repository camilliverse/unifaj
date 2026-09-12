package unifaj.com.planosaude.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifaj.com.planosaude.entity.Paciente;
import unifaj.com.planosaude.exception.ResourceNotFoundException;
import unifaj.com.planosaude.repository.PacienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente nao encontrado com id: " + id));
    }

    public Paciente cadastrar(Paciente paciente) {
        // garante que um POST sempre cria um registro novo, ignorando id enviado por engano
        paciente.setId(null);
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente dadosAtualizados) {
        Paciente existente = buscarPorId(id);

        existente.setNome(dadosAtualizados.getNome());
        existente.setCpf(dadosAtualizados.getCpf());
        existente.setTelefone(dadosAtualizados.getTelefone());
        existente.setEmail(dadosAtualizados.getEmail());
        existente.setEndereco(dadosAtualizados.getEndereco());
        existente.setNumeroCarteirinha(dadosAtualizados.getNumeroCarteirinha());
        existente.setDataNascimento(dadosAtualizados.getDataNascimento());
        existente.setPlanoSaude(dadosAtualizados.getPlanoSaude());

        return pacienteRepository.save(existente);
    }

    public void remover(Long id) {
        Paciente existente = buscarPorId(id);
        pacienteRepository.delete(existente);
    }
}
