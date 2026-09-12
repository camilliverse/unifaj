package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.PlanoSaude;

public interface PlanoSaudeRepository extends JpaRepository<PlanoSaude, Long> {
}
