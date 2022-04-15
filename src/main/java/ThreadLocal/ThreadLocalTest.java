package ThreadLocal;

import java.util.stream.IntStream;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        Integer thing = threadLocal.get();
        System.out.println(thing
        );


    }



}
