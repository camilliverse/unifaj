package br.edu.unifaj.cc.poo.aula7;

public class UtilizaBox {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box();
        box1.put(1);

        Box<String> box2 = new Box();
        box2.put("São Paulo");

        Integer valor1 = box1.get();  //Erro exige cast
        String valor2 = box2.get();   //Erro exige cast
    }
}
