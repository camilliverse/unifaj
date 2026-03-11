package br.edu.unifaj.cc.aula4;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(){

    }
    public Pessoa(String nome, int idade , String cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void andar(){
        System.out.println(nome + " " + idade + " " + " " + cpf + " " + "Pessoa andando" );
    }

    public void descansar(){
        System.out.println(nome + " " + idade + " " + " " + cpf + " " + "Pessoa descansando" );
    }
}
