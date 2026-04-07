package br.edu.unifaj.cc.poo.aula5.arrow;

public class TesteArrowFunction {

    public static void main(String[] args) {
        testExecute(a -> a.toLowerCase() );
    }


    public static String testExecute(Execute ex) {
        return ex.execute("Maria");
    }
}
