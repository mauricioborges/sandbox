package io.github.mauricioborges.udemy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
@ComponentScan
public class AppConfig {

    public static final String ALONE_HALFLING = "alone_halfling";
    public static final String HALFLING = "halfling";

    @Bean(name="halfling")
    @Scope(value = SCOPE_PROTOTYPE)
    public Halfling getHalfling() {
        Halfling halfing = new Halfling("Halflingberg", 123);
        halfing.setOwnedPerson(new Person());
        return halfing;

    }

    @Bean(name="alone_halfling")
    public Halfling getAloneHalfling() {
        Halfling halfling = new Halfling("Halflingberg", 125);
        halfling.setOwnedPerson(new Person());
        return halfling;
    }
}