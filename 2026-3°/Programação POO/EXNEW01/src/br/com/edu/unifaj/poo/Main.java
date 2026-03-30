package br.com.edu.unifaj.poo;

public class Main {
    public static void main(String[] args) {
        cdItem cd1 = new cdItem();
        cd1.setId(1);
        cd1.setName("No Diggity");
        cd1.setCantor("Blackstreet");
        cd1.setAnoDeLancamento(2018);
        cd1.setNumTrilhas(1);
        System.out.println("Id: " + cd1.getId() + "\n" +
                "Nome: "  + cd1.getName()+ "\n" +
                "Cantor: "   + cd1.getCantor()+ "\n" +
                "Ano de lancamento: " + cd1.getAnoDeLancamento()+ "\n" +
                "Trilhas: " +  cd1.getNumTrilhas() );
    }


}
