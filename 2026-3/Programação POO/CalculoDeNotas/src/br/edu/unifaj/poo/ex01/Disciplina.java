package br.edu.unifaj.poo.ex01;

import java.time.DayOfWeek;

public class Disciplina {
    private int id;
    private String nome;
    private String descricao;
    private DayOfWeek diaSemana;

    public Disciplina(int id, String nome, String descricao, DayOfWeek diaSemana) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.diaSemana = diaSemana;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }
    @Override
    public String toString() {
        return "Disciplina: " + nome +
                "\nDescrição: " + descricao +
                "\nDia: " + diaSemana;
    }


}
