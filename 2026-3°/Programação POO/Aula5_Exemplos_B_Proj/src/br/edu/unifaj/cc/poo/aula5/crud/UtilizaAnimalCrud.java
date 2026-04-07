package br.edu.unifaj.cc.poo.aula5.crud;

public class UtilizaAnimalCrud {
    public static void main(String[] args) {
        Crud crud = new AnimalCrud();

        Animal a = new Animal();
        a.setId(1l);
        a.setEspecie("Felino");
        a.setEspecie("Frajola");

        crud.create(a);
        crud.getAll();
        crud.update(a);
        crud.delete(a.getId());
    }
}
