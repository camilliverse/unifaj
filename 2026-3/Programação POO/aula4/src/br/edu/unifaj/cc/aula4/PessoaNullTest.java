package br.edu.unifaj.cc.aula4;

public class PessoaNullTest {
    public static Pessoa pessoa;

    static void main(String[] args) {
    pessoa.setNome("Camis");
    pessoa.setSalario(45000);

        System.out.println(pessoa.getNome() +  "Camis sonha com" + pessoa.getSalario() + "Salario" );

    }
}

