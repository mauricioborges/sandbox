package io.github.mauricioborges.udemy;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ApplicationContextThroughClassPlaygroundTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test()
    public void itDoesntAlwaysReturnTheSameObjectWhenUsingComponent() throws Exception {
        assertEquals(context.getBean(Person.class), context.getBean(Person.class));

    }

    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void multipleBeansWithSameReturnWouldFail() throws Exception {
        assertEquals(context.getBean(Halfling.class), context.getBean(Halfling.class));
    }

    @Test
    public void itCanAlsoNotUseComponentAndUseMethod() throws Exception {
        assertEquals(context.getBean(AppConfig.ALONE_HALFLING), context.getBean(AppConfig.ALONE_HALFLING));
    }

    @Test
    public void byDefaultItUsesSingletonButYouCanChange() throws Exception {
        assertNotEquals(context.getBean(AppConfig.HALFLING), context.getBean(AppConfig.HALFLING));

    }
}