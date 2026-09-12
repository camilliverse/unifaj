package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {
}
