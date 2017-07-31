package com.paranora;

import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class AppTest {

    @Test
    public void test_001(){

        System.out.println("hello.");
    }

}