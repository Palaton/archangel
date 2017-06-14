package com.paranora;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class AppTest  {

    public AppTest(){

    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void test() {
        System.out.println("hello.");
    }
}
