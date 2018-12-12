package chapter13;

import java.util.stream.LongStream;

/**
 * Created by shira on 12/12/2018.
 */
public class FactorialStreamsDemo {

    static long factorial(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a,b) -> a*b);
    }

    public static void main(String[] args) {

        long n = factorial(5);
        System.out.println("n = " + n);
    }
}
