package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
