package br.edu.unifaj.cc.poo.exercio07;

public class MainAlocaoObjetos {
    public static void main(String[] args) {
        Universidade univ = new Universidade();
        univ.setNome("Unifaj");
        univ.setCurso1(new Curso());
        univ.setCurso2(new Curso());
        univ.setCurso3(new Curso());
        univ.getCurso1().setNome("Ciencia da Computação");
        univ.getCurso2().setNome("Fisioterapia");
        univ.getCurso3().setNome("Advocacia");

        univ.getCurso1().setDisc1(new Disciplina());
        univ.getCurso2().setDic12(new Disciplina());
        univ.getCurso2().setDisc3(new Disciplina());
        univ.getCurso1().getDisc1().setNome("Programção Orientada a objeto");
        univ.getCurso2().getDic12().setNome("Ossos");
        univ.getCurso3().getDisc3().setNome("Criminalista");

        Professor p1 = new Professor("Otavio", "Mestre");
        univ.getCurso1().getDisc1().setProf(p1);

        Professor p2 = new Professor("Gustavo","Mestrinho");
        univ.getCurso2().getDic12().setProf(p2);

        Professor p3 = new Professor("Beatriz", "Mestrona");
        univ.getCurso3().getDisc3().setProf(p3);


        System.out.println("Universidade" + univ.getNome());
        System.out.println("Primeira opção de curso: " + univ.getCurso1().getNome());
        System.out.println("Segunda opção de curso: " + univ.getCurso2().getNome());
        System.out.println("Terceira opção de curso: " + univ.getCurso3().getNome());
        System.out.println("Disc 1 - Curso 1" + univ.getCurso1().getDisc1().getNome());
        System.out.println("Prof da Dic1 Curso1" + univ.getCurso1().getDisc1().getProf().getNome());


    }
}
