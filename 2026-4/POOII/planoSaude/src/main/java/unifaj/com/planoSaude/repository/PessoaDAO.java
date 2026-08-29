package unifaj.com.planoSaude.dao;

import unifaj.com.planoSaude.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteDAO extends JpaRepository<Paciente, Long> {
}