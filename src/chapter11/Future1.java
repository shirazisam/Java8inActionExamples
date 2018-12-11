package chapter11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;

/**
 * Created by shira on 01/12/2018.
 */
public class Future1 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
                                                    @Override
                                                    public Double call() throws Exception {
                                                        return doSomeLongComputation();
                                                    }
                                                }

        );
        doSomethingElse((x,y) -> x * y, 3, 4);
        doSomethingElse(Math::max, 10, 7);
    }

    private static void doSomethingElse(MyBinaryOperator<Integer> fn, int op1, int op2) {
        System.out.println("Future1.doSomethingElse");
        delay(1000);
        Integer result = fn.apply(op1, op2);
        System.out.println("Future1.doSomethingElse =" + result);
    }

    private static Double doSomeLongComputation() {
        System.out.println("Future1.doSomeLongComputation");
        delay(3000);
        System.out.println("Future1.doSomeLongComputation");
        return null;
    }

    private static void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
