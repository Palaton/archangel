package com.paranora;

import io.reactivex.Flowable;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by yangqun on 2017/07/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class LambdaLabTest {

    @Test
    public void test_001() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        Flowable<List<Integer>> flowable= Flowable.just(list);
        flowable.filter(i->i.stream().filter(a->a>1).count()>0);
    }
}
