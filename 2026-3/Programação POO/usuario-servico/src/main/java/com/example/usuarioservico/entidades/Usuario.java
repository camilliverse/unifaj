package com.example.usuarioservico.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nome;
    private String usuario;
    private String senhaMD5;


}
