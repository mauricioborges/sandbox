package io.github.mauricioborges.udemy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Person {
    @Override
    public String toString() {
        return "Person{}";
    }

    @PostConstruct
    public void speak() {
        System.out.println("Hello there, I've been constructed");
    }


    @PreDestroy
    public void die() {
        System.out.println("I'm your father");
    }
}
