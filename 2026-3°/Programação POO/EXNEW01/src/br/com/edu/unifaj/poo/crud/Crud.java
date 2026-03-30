package br.com.edu.unifaj.poo.crud;

import java.util.List;

public interface Crud {

    Entity get(Long id);
    List<Entity> getAll(Animal animal);
    Entity create(Entity obj);
    Entity update(Entity obj);
    Entity delete(Long id);


}
