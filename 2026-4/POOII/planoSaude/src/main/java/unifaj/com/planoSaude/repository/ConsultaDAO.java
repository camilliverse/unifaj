package unifaj.com.planoSaude.dao;

import unifaj.com.planoSaude.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaDAO extends JpaRepository<Consulta, Long> {
}