package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Consulta;

public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {

}
