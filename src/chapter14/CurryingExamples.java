package chapter14;

import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

/**
 * Created by shira on 13/12/2018.
 */
public class CurryingExamples {

    // generic linear unit converter
    static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }

    static Function<Integer, Integer> curryMutliply(int x) {
        return (Integer y) -> x * y;
    }


    public static void main(String[] args) {

        DoubleUnaryOperator cToFconverter = curriedConverter(9/5.0, 32);

        double farenheit = cToFconverter.applyAsDouble(100);  // C -> F
        System.out.println("farenheit = " + farenheit);

        Function<Integer, Integer> curriedFunction = curryMutliply(12);
        Integer result = curriedFunction.apply(3);
        System.out.println("result = " + result);

        Stream.of(1, 3, 5, 7)
                .map(curryMutliply(2))
                .forEach(System.out::println);
    }
}
