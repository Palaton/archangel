package com.paranora;

import io.reactivex.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cglib.core.Converter;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-context-test.xml"})
@PropertySource("classpath:/application.properties")
public class AppTest {

    public AppTest() {

    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void test() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        String [] strArray = new String[] {"Aa", "Bb", "Cc"};

        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .filter((s)->s.length()>1)
                .map((s)->"flyceek:"+s)
                .flatMap((s)->Stream.of(strArray))
                .forEach(System.out::println);

        System.out.println("hello.");
    }

    @Test
    public void testFunction() {

        Comparator<Integer> c=(Integer a1, Integer b1)->{
            return a1>b1?1:0;
        };

        Object r=BinaryOperator.minBy(c).apply(112323,2223333);

        System.out.println(r);
        new App().hello(() -> {
            return "i am flyceek";
        });
    }

    private static int countNum(Stream<Character> stream){
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }

    @Test
    public void test_001(){
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        System.out.println("ordered total: " + countNum(stream));

        Spliterator<Character> spliterator = new NumCounterSpliterator(arr);
        // 传入true表示是并行流
        Stream<Character> parallelStream = StreamSupport.stream(spliterator, true);
        System.out.println("parallel total: " + countNum(parallelStream));
    }

    @Test
    public void test_002(){
//        Optional accResult = Stream.of(1, 2, 3, 4)
//                .reduce((acc, item) -> {
//                    System.out.println("acc : "  + acc);
////                    acc += item;
//                    System.out.println("item: " + item);
////                    System.out.println("acc+ : "  + acc);
//                    System.out.println("--------");
//                    return acc;
//                });

        int accResultA = Stream.of(1, 2, 3, 4)
                .reduce(0, (acc, item) -> {
                    System.out.println("acc : "  + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });
    }

    @Test
    public void test_003(){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        arrayList.add(1);

        arrayList.get(0);
    }

    @Test
    public void test_004(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());

        outputStream.forEach(System.out::println);
    }

    @Test
    public void test_005(){

        io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {

            }
        });
    }
}
