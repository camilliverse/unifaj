package com.aula8.estadosmunicipios.controller;

import com.aula8.estadosmunicipios.dto.MunicipioDTO;
import com.aula8.estadosmunicipios.repository.MunicipioRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

    private final MunicipioRepository repository;

    public MunicipioController(MunicipioRepository repository) {
        this.repository = repository;
    }

    /**
     * GET /api/municipios                      -> todos os municipios
     * GET /api/municipios?estado=Sao Paulo     -> filtrados pelo NOME do estado
     */
    @GetMapping
    public List<MunicipioDTO> listar(@RequestParam(name = "estado", required = false) String estado) {
        if (estado == null || estado.isBlank()) {
            return repository.listarTodos();
        }
        return repository.listarPorNomeEstado(estado.trim());
    }

    /** GET /api/municipios/total */
    @GetMapping("/total")
    public long total() {
        return repository.count();
    }
}
