package com.paranora;

import com.paranora.threadlab.Counter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yangqun on 2017/07/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class ThreadLabTest {

    @Test
    public void test_001(){
        int intCount=1000;
        CountDownLatch countDownLatch=new CountDownLatch(intCount);
        Counter counter=new Counter(countDownLatch);

        for (int i = 0; i < intCount; i++) {
            new Thread(()->counter.inc()).start();
        }

        try
        {
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + counter.getAtomicInteger().get());
    }

    public static volatile boolean stop=false;

    @Test
    public void test_002(){
        while(!stop){
            System.out.println("ok");
        }

        stop = true;
    }
}
