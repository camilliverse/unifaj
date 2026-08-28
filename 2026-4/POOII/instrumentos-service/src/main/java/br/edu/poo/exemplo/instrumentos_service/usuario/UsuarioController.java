package br.edu.poo.exemplo.instrumentos_service.usuario;

import br.edu.poo.exemplo.instrumentos_service.Retorno;
import br.edu.poo.exemplo.instrumentos_service.instrumento.Instrumento;
import br.edu.poo.exemplo.instrumentos_service.instrumento.InstrumentoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioDao dao;

    @PostMapping("/usuarioValidar")
    public Retorno validar(@RequestBody Usuario u) {
        try {
            return new Retorno(dao.validarSenha(u));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }


    @PostMapping("/usuario")
    public Retorno incluir(@RequestBody Usuario i) {
        try {
            return new Retorno(dao.incluir(i));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }


}
