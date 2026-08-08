package br.edu.unifaj.poo.Aula6Exercicio715;

import java.util.Arrays;

public class Manipulations{
    public static void main(String[] args){

        System.out.println("RA: 12529495");
        System.out.println("NOME: Camilli Dos Santos");

        System.out.println("RA: 12529937");
        System.out.println("NOME: Otavio Siqueira");

        double[] arrayDouble={8.4,9.3,0.2,7.9,3.4};

        Arrays.sort(arrayDouble);

        System.out.printf("%narrayDouble: ");

        for(double valor:arrayDouble){
            System.out.printf("%.1f ",valor);
        }

        int[] arrayPreenchido=new int[10];

        Arrays.fill(arrayPreenchido,7);

        mostrarArray(
                arrayPreenchido,
                "arrayPreenchido"
        );

        int[] arrayInt={1,2,3,4,5,6};

        int[] copiaArrayInt=
                new int[arrayInt.length];

        System.arraycopy(
                arrayInt,
                0,
                copiaArrayInt,
                0,
                arrayInt.length
        );

        mostrarArray(arrayInt,"arrayInt");

        mostrarArray(
                copiaArrayInt,
                "copiaArrayInt"
        );

        boolean igual=
                Arrays.equals(
                        arrayInt,
                        copiaArrayInt
                );

        System.out.printf(
                "%n%narrayInt %s copiaArrayInt%n",
                (igual?"=":"!=")
        );

        igual=Arrays.equals(
                arrayInt,
                arrayPreenchido
        );

        System.out.printf(
                "arrayInt %s arrayPreenchido%n",
                (igual?"=":"!=")
        );

        int posicao=
                Arrays.binarySearch(
                        arrayInt,
                        5
                );

        if(posicao>=0){

            System.out.printf(
                    "Encontrou 5 na posição %d do arrayInt%n",
                    posicao
            );

        }else{

            System.out.println(
                    "5 não encontrado no arrayInt"
            );
        }

        posicao=
                Arrays.binarySearch(
                        arrayInt,
                        8763
                );

        if(posicao>=0){

            System.out.printf(
                    "Encontrou 8763 na posição %d do arrayInt%n",
                    posicao
            );

        }else{
            System.out.println("8763 não encontrado no arrayInt");
        }
    }

    public static void mostrarArray(
            int[] array,
            String descricao
    ){

        System.out.printf(
                "%n%s: ",
                descricao
        );

        for(int valor:array){
            System.out.printf(
                    "%d ",
                    valor
            );
        }
    }
}