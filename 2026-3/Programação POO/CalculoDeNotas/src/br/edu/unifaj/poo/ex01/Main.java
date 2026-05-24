package br.edu.unifaj.poo.ex01;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Aluno
        System.out.println(" | Coloque a baixo a itentificação do aluno(a) |");
        System.out.print("RA: ");
        int RA = input.nextInt();
        input.nextLine(); // limpa buffer

        System.out.print("Nome: ");
        String nome = input.nextLine();

        System.out.print("Idade: ");
        int Idade = input.nextInt();
        input.nextLine();

        System.out.print("Turma: ");
        String Turma = input.nextLine();

        Aluno aluno = new Aluno(RA, nome, Idade, Turma);

        // Disciplina
        System.out.println(" | Agora coloque abaixo a identificação da disciplina |");

        System.out.print("id: ");
        String id = input.nextLine();

        System.out.print("Nome: ");
        String Nome = input.nextLine();

        System.out.print("Descrição: ");
        String descricao = input.nextLine();

        System.out.print("DiaSemana (segunda, terça, ...): ");
        String DiaSemana = input.nextLine();

        int idInt = Integer.parseInt(id);

        java.time.DayOfWeek dia;

        switch (DiaSemana.toLowerCase()) {
            case "segunda": dia = java.time.DayOfWeek.MONDAY; break;
            case "terca":
            case "terça": dia = java.time.DayOfWeek.TUESDAY; break;
            case "quarta": dia = java.time.DayOfWeek.WEDNESDAY; break;
            case "quinta": dia = java.time.DayOfWeek.THURSDAY; break;
            case "sexta": dia = java.time.DayOfWeek.FRIDAY; break;
            case "sabado":
            case "sábado": dia = java.time.DayOfWeek.SATURDAY; break;
            case "domingo": dia = java.time.DayOfWeek.SUNDAY; break;
            default: throw new IllegalArgumentException("Dia inválido");
        }

        Disciplina dis = new Disciplina(idInt, Nome, descricao, dia);

        // Exercicio
        System.out.println(" | Agora coloque abaixo a identificação do exercício |");

        System.out.print("Título do exercício: ");
        String titulo = input.nextLine();

        System.out.print("Descrição: ");
        String descricaoExercicio = input.nextLine();

        System.out.print("Nota máxima: ");
        double notaMax = input.nextDouble();
        input.nextLine();

        java.time.LocalDate dataInicio = java.time.LocalDate.now();
        java.time.LocalDate dataFim = java.time.LocalDate.now();

        Exercicio exercicio = new Exercicio(
                1,
                titulo,
                descricaoExercicio,
                dataInicio,
                dataFim,
                notaMax,
                dis
        );

        //Correção
        System.out.print("Nota do aluno: ");
        double nota = input.nextDouble();

        Correcao correcao = new Correcao(aluno, exercicio, nota);

        //Resultado
        System.out.println(correcao);

        input.close();


    }
}
