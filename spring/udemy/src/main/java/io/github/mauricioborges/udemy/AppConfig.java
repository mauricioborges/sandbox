package io.github.mauricioborges.udemy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}