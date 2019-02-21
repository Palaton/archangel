package com.paranora;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource(value = {"classpath:/application.properties"})
public class AppTest {

    @org.junit.Test
    public void test_001(){
//        Logger logger = LoggerFactory.getLogger("flyceek");
//        logger.debug("Hello world.");
//        logger.info("abcdf");


        System.out.println("hello.");
    }

}
