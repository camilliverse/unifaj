package com.example.usuarioservico.repository;

import com.example.usuarioservico.entidades.Usuario;
import com.example.usuarioservico.servico.UsuarioServico;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class UsuarioRepository {
    private static Map<Long, Usuario> usuarios = new TreeMap<>();

    private static long contador = 1;

    public UsuarioRepository() {
        Usuario u1 = new Usuario(contador++, "Felipe" , "Felipe" , UsuarioServico.encodeMD5("12345"));

        Usuario u2 = new Usuario(contador++,
                "maria" , "mariazinha" , UsuarioServico.encodeMD5("12345"));

        usuarios.put(contador++, u1);
        usuarios.put(contador++, u2);
    }

    public Usuario findUsuarioByUsuario(String user) {
        for(Usuario u : usuarios.values()){
            if(u.getUsuario().equals(user)){
                return u;
            }
        }
        return null;
    }

}
