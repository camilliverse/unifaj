package com.planosaude.config;

import com.planosaude.model.Beneficiario;
import com.planosaude.model.Medico;
import com.planosaude.repository.BeneficiarioRepository;
import com.planosaude.repository.MedicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Popula o banco H2 em memoria com alguns registros de exemplo,
 * facilitando a demonstracao dos GETs logo apos subir a aplicacao.
 */
@Component
public class CarregadorDeDados implements CommandLineRunner {

    private final MedicoRepository medicoRepository;
    private final BeneficiarioRepository beneficiarioRepository;

    public CarregadorDeDados(MedicoRepository medicoRepository, BeneficiarioRepository beneficiarioRepository) {
        this.medicoRepository = medicoRepository;
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @Override
    public void run(String... args) {
        medicoRepository.save(new Medico(null, "Dr. Joao Silva", "CRM-12345", "Cardiologia", "(19) 99999-0001"));
        medicoRepository.save(new Medico(null, "Dra. Maria Souza", "CRM-54321", "Pediatria", "(19) 99999-0002"));

        beneficiarioRepository.save(new Beneficiario(null, "Carlos Pereira", "111.111.111-11", "1985-03-10", "Premium", true));
        beneficiarioRepository.save(new Beneficiario(null, "Ana Oliveira", "222.222.222-22", "1992-07-22", "Basico", true));
    }
}
