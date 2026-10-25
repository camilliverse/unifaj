package br.edu.planosaude.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
}
