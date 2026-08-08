package com.example.usuarioservico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResquestDto {
    private String usuario;
    private String senha;
}
