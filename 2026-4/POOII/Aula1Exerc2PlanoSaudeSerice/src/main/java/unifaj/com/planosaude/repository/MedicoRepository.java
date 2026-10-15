package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}