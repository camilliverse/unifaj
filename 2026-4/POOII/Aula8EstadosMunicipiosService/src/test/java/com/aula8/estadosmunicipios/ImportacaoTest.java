package com.aula8.estadosmunicipios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.aula8.estadosmunicipios.repository.EstadoRepository;
import com.aula8.estadosmunicipios.repository.MunicipioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImportacaoTest {

    @Autowired
    EstadoRepository estados;

    @Autowired
    MunicipioRepository municipios;

    @Test
    void importouTudo() {
        assertEquals(27, estados.count());
        assertEquals(5570, municipios.count());
    }

    @Test
    void filtraPorNomeDoEstado() {
        var sp = municipios.listarPorNomeEstado("são paulo");
        assertFalse(sp.isEmpty());
        assertEquals("São Paulo", sp.get(0).estadoNome());
    }
}
