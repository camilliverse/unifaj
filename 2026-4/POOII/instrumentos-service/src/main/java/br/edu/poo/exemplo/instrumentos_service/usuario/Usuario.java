package br.edu.poo.exemplo.instrumentos_service.usuario;

import lombok.Data;

@Data
public class Usuario {
    private int id;
    private String usuario;
    private String senha;
    private String server;
    private String token;
}
