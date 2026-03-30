package br.com.edu.unifaj.poo.crud;

public class Animal implements Entity {
    private Long id;
    private String especie;
    private String nome;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
