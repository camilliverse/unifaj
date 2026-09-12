package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
