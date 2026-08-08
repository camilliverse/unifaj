package br.edu.unifaj.poo.Aula6Exercicio714;

public class InitArray{
    public static void main(String[] args){

        System.out.println("RA: 12529495");
        System.out.println("NOME:Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME:Otavio Siqueira");

        if(args.length!=3){

            System.out.printf(
                    "Erro: digite novamente o comando completo,%n"+
                            "incluindo tamanho do array, valor inicial e incremento.%n"
            );

        }else{

            int tamanhoArray=Integer.parseInt(args[0]);

            int[] array=new int[tamanhoArray];

            int valorInicial=Integer.parseInt(args[1]);
            int incremento=Integer.parseInt(args[2]);

            for(int contador=0;contador<array.length;contador++){
                array[contador]=valorInicial+incremento*contador;
            }

            System.out.printf("%s%8s%n","Índice","Valor");

            for(int contador=0;contador<array.length;contador++){
                System.out.printf(
                        "%5d%8d%n",
                        contador,
                        array[contador]
                );
            }
        }
    }
}