package br.edu.unifaj.cc.poo.aula5.crud;

import java.util.List;

public interface Crud {
    Entity get(Long id);
    List<Entity> getAll();
    Entity create(Entity obj);
    Entity update(Entity obj);
    Entity delete(Long id);
}
