package br.edu.unifaj.cc.poo.aula01_convenio_service.service;

import org.springframework.stereotype.Service;

@Service //logica de negocio
public class PacienteService {
    public String participarConsulta(){
        return "Paciente participou da consulta";
    }

    public String fazerExame(){
        return "Paciente fez o exame de sangue";
    }


}
