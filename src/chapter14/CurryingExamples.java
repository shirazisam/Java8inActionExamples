package chapter14;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

/**
 * Created by shira on 13/12/2018.
 */
public class CurryingExamples {

    // generic linear unit converter
    static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }

    public static void main(String[] args) {

        DoubleUnaryOperator cToFconverter = curriedConverter(9/5.0, 32);

        double farenheit = cToFconverter.applyAsDouble(100);  // C -> F
        System.out.println("farenheit = " + farenheit);
    }
}
