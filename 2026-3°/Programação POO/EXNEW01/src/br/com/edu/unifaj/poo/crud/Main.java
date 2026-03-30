package br.com.edu.unifaj.poo.crud;

public class Main {
    public static void main(String[] args) {
        Crud crud = new AnimalCrud();
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setEspecie("Felino");
        animal.setNome("Catra");

        crud.create(animal);
        crud.getAll(animal);
        crud.update(animal);
        crud.delete(animal.getId());

    }
}
