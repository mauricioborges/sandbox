package io.github.mauricioborges.udemy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class ApplicationContextPlaygroundTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test()
    public void itDoesntAlwaysReturnTheSameObjectWhenUsingComponent() throws Exception {
        assertEquals(context.getBean(Person.class), context.getBean(Person.class));

    }
}