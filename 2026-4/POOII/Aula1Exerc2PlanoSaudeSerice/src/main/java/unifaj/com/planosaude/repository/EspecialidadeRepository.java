package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
