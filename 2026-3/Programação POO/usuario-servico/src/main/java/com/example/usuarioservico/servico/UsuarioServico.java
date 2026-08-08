package com.example.usuarioservico.servico;

import com.example.usuarioservico.dto.LoginResponseDto;
import com.example.usuarioservico.dto.LoginResquestDto;
import com.example.usuarioservico.entidades.Usuario;
import com.example.usuarioservico.repository.UsuarioRepository;

import java.security.MessageDigest;

public class UsuarioServico {
    UsuarioRepository respository;

    public LoginResponseDto login(LoginResquestDto dto) {
        LoginResponseDto resp = new LoginResponseDto();
        if (dto.getUsuario() == null || dto.getSenha() == null) {
            resp.setStatus("NOK");
            resp.setErro("Informações incompletas");
            return resp;
        }
        if (dto.getUsuario().isBlank() || dto.getSenha().isBlank()) {
            resp.setStatus("NOK");
            resp.setErro("Informações em branco");
            return resp;
        }
        Usuario u = respository.findUsuarioByUsuario(dto.getUsuario());
        if (u == null) {
            resp.setStatus("NOK");
            resp.setErro("Usuário não encontrado");
            return resp;
        }
        //Criptografar a senha
        String senhaMD5 = encodeMD5(dto.getSenha());
        if (senhaMD5.equals(u.getSenhaMD5())) {
            resp.setStatus("NOK");
            resp.setErro("Senha não confere.");
            return resp;
        }
        resp.setStatus("OK");
        resp.setToken("Bearer XYZ");
        return resp;
    }


    public static String encodeMD5(String senha) {
        try {
            // Cria a instância do MessageDigest configurada para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Aplica a criptografia/hash nos bytes da string
            byte[] hashBytes = md.digest(senha.getBytes());

            // Converte o array de bytes resultante para o formato Hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o algoritmo MD5", e);
        }
    }
}