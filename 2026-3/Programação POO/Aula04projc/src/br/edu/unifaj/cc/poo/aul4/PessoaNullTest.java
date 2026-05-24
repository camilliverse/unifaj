package br.edu.unifaj.cc.poo.aul4;

public class PessoaNullTest {
    private static Pessoa pessoa;

     public static void main(String[] args) {
         pessoa.setNome("Camilli Gostosa");
         pessoa.setIdade(20);
         System.out.println(pessoa.getNome() + "Camilli tem" + pessoa.getIdade() + "Anos");
    }
}
