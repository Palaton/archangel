package com.paranora.trist;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"classpath:/spring-context-test.xml"})
public class AppTest extends TestCase
{
    @org.junit.Test
    public void test(){

        System.out.println("hello.");
    }
}
