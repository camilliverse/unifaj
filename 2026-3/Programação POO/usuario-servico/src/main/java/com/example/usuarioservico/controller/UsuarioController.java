package com.example.usuarioservico.controller;

import com.example.usuarioservico.dto.LoginResponseDto;
import com.example.usuarioservico.dto.LoginResquestDto;
import com.example.usuarioservico.servico.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioServico serivo;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginResponseDto dto){
        return serivo.login(dto);
    }

    public LoginResponseDto login(LoginResquestDto dto){
        return serivo.login(dto);
    }

}
