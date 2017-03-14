package io.github.mauricioborges.udemy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApplicationContextThroughXMLPlaygroundTest {

    ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext("classpath:beans.xml");

    }

    @Test
    public void itPrintsTheAloneHalfing() throws Exception {
        assertEquals(context.getBean("singleton_halfling").toString(), "Halfling{name='Halflingzildo', age=100, ownedPerson=null}");

    }

    @Test
    public void itPrintsTheHalfing() throws Exception {
        assertEquals(context.getBean("halflingthatworks").toString(), "Halfling{name='Halflingzildo', age=100, ownedPerson=Person{}}");

    }

    @Test(expected = BeanCreationException.class)
    public void itFailsBecauseTheBeanIsMisconfigured() throws Exception {
        context.getBean("halfling");

    }


    @After
    public void tearDown() throws Exception {
        ((FileSystemXmlApplicationContext) context).close();

    }

    @Test
    public void inFactItWorks() throws Exception {
        assertNotNull(context.getBean("singleton_halfling"));

    }
}
