package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Internacao;

public interface InternacaoRepository extends JpaRepository<Internacao, Long> {
}
