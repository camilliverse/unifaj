package br.com.edu.unifaj.poo.crud;

import java.util.ArrayList;
import java.util.List;

public class AnimalCrud implements Crud {
    List<Entity> list = new ArrayList<>();

    @Override
    public Entity get(Long id) {
        for(Entity et: list){
            if (et.getId()== id){
                return et;
            }else{
                return null;
            }
        }

        return null;
    }

    @Override
    public List<Entity> getAll(Animal animal) {
        return list;
    }

    @Override
    public Entity create(Entity obj) {
        list.add(obj);
        return obj;
    }

    @Override
    public Entity update(Entity obj) {
         for(int i = 0; i < list.size(); i++){
             Entity exist = list.get(i);
             if(exist.getId() == obj.getId()){
                 list.set(i, obj);
             }
         }
         return obj;
    }

    @Override
    public Entity delete(Long id) {
        for (Entity et : list) {
            if (et.getId() == id) {
                list.remove(et);
                return et;
            }
        }
        return null;
    }
    public Animal criarObj(){
        return new Animal();
    }

}
