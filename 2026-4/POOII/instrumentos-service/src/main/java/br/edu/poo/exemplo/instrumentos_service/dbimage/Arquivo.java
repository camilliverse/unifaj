package br.edu.poo.exemplo.instrumentos_service.dbimage;

import lombok.Data;

@Data
public class Arquivo {
    private int id;
    private String arquivo;
    private int type;
    private byte[] data;
}
