package com.aula8.estadosmunicipios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/** Tabela ESTADOS. O id e o codigo do estado informado no CSV (COD). */
@Entity
@Table(name = "estados")
public class Estado {

    @Id
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 2)
    private String sigla;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }
}
