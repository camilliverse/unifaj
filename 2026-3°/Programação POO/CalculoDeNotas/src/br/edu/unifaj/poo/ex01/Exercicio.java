package br.edu.unifaj.poo.ex01;

import java.time.LocalDate;

public class Exercicio {
    private int Id;
    private String Titulo;
    private String Descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double notaMaxima;
    private Disciplina disciplina01;

    public Exercicio(int id, String titulo, String descricao, LocalDate dataInicio, LocalDate dataFim, double notaMaxima, Disciplina disciplina) {
        Id = id;
        Titulo = titulo;
        Descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.notaMaxima = notaMaxima;
        this.disciplina01 = disciplina;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public Disciplina getDisciplina() {
        return disciplina01;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina01 = disciplina01;
    }

    @Override
    public String toString() {
        return "Exercício: " + Titulo +
                "\nDescrição: " + Descricao +
                "\nData Inicio: " + dataInicio +
                "\nData Fim: " + dataFim +
                "\nNota Máxima: " + notaMaxima +
                "\nDisciplina: " + disciplina01.getNome();
    }
}
