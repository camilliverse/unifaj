package br.com.unifaj.poo;

public class ContarNomes {
    static void main(String[] args) {
        String[] nomes = {
                "Eve" , "Mark" , "Omini-Man" , "Mark" , "Oliver"
        };
        int contador = 0;
        for (int i = 0; i < nomes.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < i ; j++) {
                if(nomes[i].equals(nomes[j])){
                    repetido = true;
                    break;
                }
            }
            if(repetido == false){
                contador++;
            }
        }
        System.out.println("Total de nomes: " + contador);

    }
}
