package io.github.mauricioborges.udemy;

import org.springframework.stereotype.Component;

@Component
public class Person {
    @Override
    public String toString() {
        return "Person{}";
    }

    public void speak() {
        System.out.print("Hello there");
    }
}
