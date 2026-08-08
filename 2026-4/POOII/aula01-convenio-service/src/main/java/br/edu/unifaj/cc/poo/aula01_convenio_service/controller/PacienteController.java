package br.edu.unifaj.cc.poo.aula01_convenio_service.controller;

import br.edu.unifaj.cc.poo.aula01_convenio_service.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/paciente/consulta")
    public String participarConsulta(){
        return pacienteService.participarConsulta();
    }

    @GetMapping("/paciente/exame")
    public String fazerExame(){
        return pacienteService.fazerExame();
    }


}
