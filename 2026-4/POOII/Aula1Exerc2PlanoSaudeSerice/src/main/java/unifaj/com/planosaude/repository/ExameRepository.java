package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}
