package com.aula8.estadosmunicipios.repository;

import com.aula8.estadosmunicipios.model.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findAllByOrderByNomeAsc();
}
