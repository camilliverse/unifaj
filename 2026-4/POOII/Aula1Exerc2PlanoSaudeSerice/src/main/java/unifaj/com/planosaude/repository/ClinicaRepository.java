package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
}
