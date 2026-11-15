package com.aula8.estadosmunicipios.controller;

import com.aula8.estadosmunicipios.model.Estado;
import com.aula8.estadosmunicipios.repository.EstadoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private final EstadoRepository repository;

    public EstadoController(EstadoRepository repository) {
        this.repository = repository;
    }

    /** GET /api/estados */
    @GetMapping
    public List<Estado> listar() {
        return repository.findAllByOrderByNomeAsc();
    }
}
