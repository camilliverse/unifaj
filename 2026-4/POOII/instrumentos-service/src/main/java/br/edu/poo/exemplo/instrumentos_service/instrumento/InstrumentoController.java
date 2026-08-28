package br.edu.poo.exemplo.instrumentos_service.instrumento;

import br.edu.poo.exemplo.instrumentos_service.Retorno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InstrumentoController {

    @Autowired
    InstrumentoDao dao;

    @GetMapping("/instrumento")
    public Retorno listar() {
        try {
            return new Retorno(dao.listar());
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }

    @GetMapping("/instrumento/{id}")
    public Retorno obter(@PathVariable Integer id) {
        try {
            return new Retorno(dao.obter(id));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }


    @PostMapping("/instrumento")
    public Retorno incluir(@RequestBody Instrumento i) {
        try {
            return new Retorno(dao.incluir(i));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }

    @PutMapping("/instrumento/{id}")
    public Retorno alterar(@RequestBody Instrumento inst, @PathVariable Integer id) {
        try {
            return new Retorno(dao.alterar(inst));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }

    @PutMapping("/instrumentoPreco")
    public Retorno alterarPreco(@RequestBody Instrumento i) {
        try {
            return new Retorno(dao.alterarPreco(i));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }

    @DeleteMapping("/instrumento/{id}")
    public Retorno excluir(@PathVariable Integer id) {
        try {
            return new Retorno(dao.excluir(id));
        } catch (Exception ex) {
            return new Retorno(ex.getMessage());
        }
    }

}
