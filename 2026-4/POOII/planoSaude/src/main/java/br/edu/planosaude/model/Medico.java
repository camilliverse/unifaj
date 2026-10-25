package br.edu.planosaude.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String crm;
    private String especialidade;
}
