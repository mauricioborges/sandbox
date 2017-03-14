package io.github.mauricioborges.udemy;

public class Halfling {

    private String name;


    private Integer age;

    private Person ownedPerson;


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setOwnedPerson(Person person) {
        this.ownedPerson = person;

    }

    public Halfling(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println("I'm a halfling");
    }

    @Override
    public String toString() {
        return "Halfling{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ownedPerson=" + ownedPerson +
                '}';
    }
}
