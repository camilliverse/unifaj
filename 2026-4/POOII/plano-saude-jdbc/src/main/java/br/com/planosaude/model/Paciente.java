package br.com.planosaude.model;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private String numeroCarteirinha;

    public Paciente() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getNumeroCarteirinha() { return numeroCarteirinha; }
    public void setNumeroCarteirinha(String numeroCarteirinha) { this.numeroCarteirinha = numeroCarteirinha; }
}
