package br.edu.unifaj.cc.poo.aula01_convenio_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {
    private Date nascimento;

}
