package io.github.mauricioborges.udemy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean(name="halfling")
    @Scope(value = SCOPE_PROTOTYPE)
    public Halfling getHalfling() {
        return new Halfling();
    }

    @Bean(name="alone_halfling")
    public Halfling getAloneHalfling() {
        return new Halfling();
    }
}