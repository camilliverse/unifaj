package unifaj.com.planosaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifaj.com.planosaude.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
