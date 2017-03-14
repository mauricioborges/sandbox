package io.github.mauricioborges.udemy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configurable
public class App {

    public static void main(String[] args) {
        //interesting, I can use only this interface (superinterface for ApplicationContext)
        BeanFactory context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Person.class).speak();
    }

}
