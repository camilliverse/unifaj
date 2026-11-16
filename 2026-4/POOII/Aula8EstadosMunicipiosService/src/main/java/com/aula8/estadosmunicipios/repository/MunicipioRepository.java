package com.aula8.estadosmunicipios.repository;

import com.aula8.estadosmunicipios.dto.MunicipioDTO;
import com.aula8.estadosmunicipios.model.Municipio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    /** Todos os municipios, trazendo o nome do estado via JOIN com a tabela estados. */
    @Query("""
            select new com.aula8.estadosmunicipios.dto.MunicipioDTO(m.id, m.nome, e.id, e.nome, e.sigla)
            from Municipio m join m.estado e
            order by m.nome
            """)
    List<MunicipioDTO> listarTodos();

    /** Filtro pelo nome do estado (sem diferenciar maiusculas/minusculas). */
    @Query("""
            select new com.aula8.estadosmunicipios.dto.MunicipioDTO(m.id, m.nome, e.id, e.nome, e.sigla)
            from Municipio m join m.estado e
            where lower(e.nome) = lower(:nomeEstado)
            order by m.nome
            """)
    List<MunicipioDTO> listarPorNomeEstado(@Param("nomeEstado") String nomeEstado);
}
