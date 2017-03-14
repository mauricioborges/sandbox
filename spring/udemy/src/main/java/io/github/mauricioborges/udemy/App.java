package io.github.mauricioborges.udemy;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configurable
public class App {

    public static void main(String[] args) {
        //interesting, I can use only BeanFactory interface (super interface for ApplicationContext)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(Person.class);
        //you must close your context somewhere to run predestroy methods
        context.close();

    }
}