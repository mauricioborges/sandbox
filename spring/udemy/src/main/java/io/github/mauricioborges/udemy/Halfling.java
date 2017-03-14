package io.github.mauricioborges.udemy;

public class Halfling {
    public void speak(){
        System.out.println("I'm a halfling");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String name(){
        return "Halflingberg";
    }
}
