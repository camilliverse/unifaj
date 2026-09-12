package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
