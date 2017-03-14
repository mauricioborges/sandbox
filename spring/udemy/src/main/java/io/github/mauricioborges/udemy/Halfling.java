package io.github.mauricioborges.udemy;

public class Halfling {

    private String name;


    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Halfling(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println("I'm a halfling");
    }


}
