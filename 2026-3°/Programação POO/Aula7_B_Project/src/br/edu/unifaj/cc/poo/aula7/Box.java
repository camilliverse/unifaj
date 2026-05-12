package br.edu.unifaj.cc.poo.aula7;

public class Box <T> {
    private T t;
    public void put(T t){
        this.t = t;
    }
    public T get() {
        return t;
    }
}
