package io.github.mauricioborges.udemy;

import javafx.application.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class ApplicationContextThroughXMLPlaygroundTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("classpath:beans.xml");

    }

    @After
    public void tearDown() throws Exception {
        ((FileSystemXmlApplicationContext)context).close();

    }

    @Test
    public void inFactItWorks() throws Exception {
        assertNotNull(context.getBean("singleton_halfling"));

    }
}
