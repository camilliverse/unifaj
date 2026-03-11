package br.edu.unifaj.cc.aula4;

public class UltilizaAluno {

    static void main(String[] args) {
       Aluno a0 = new Aluno();
       a0.descansar();
       a0.calcularMedia();


       Aluno a1 = new Aluno();
       a1.setNome("Robertinha Porca");
       a1.setIdade(25);
       a1.setCpf("2365148792-01");
       a1.setRa("1253628");
       float[] notas = {10,8,3,3};
       a1.setNotas(notas);
       a1.descansar();
       a1.andar();
       a1.estudar();

       Aluno a2 = new Aluno("Flavio Degustador", 50 , "00.451.554.26", "12563", new float[]{7,8,5,2} );
       a2.estudar();

    }

}

