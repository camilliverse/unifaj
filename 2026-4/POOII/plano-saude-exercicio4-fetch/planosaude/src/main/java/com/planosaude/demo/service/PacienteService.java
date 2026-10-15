package com.planosaude.demo.service;

import com.planosaude.demo.model.Paciente;
import com.planosaude.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente incluir(Paciente paciente) {
        paciente.setId(null);
        return pacienteRepository.save(paciente);
    }

    public Paciente alterar(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setCpf(pacienteAtualizado.getCpf());
            paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
            paciente.setTelefone(pacienteAtualizado.getTelefone());
            return pacienteRepository.save(paciente);
        }).orElse(null);
    }

    public boolean excluir(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
