package patterns.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by shira on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new XreplaceATextProcessing();
        ProcessingObject<String> p3 = new TolowercaseTextProcessing();

        p1.setSuccessor(p2).setSuccessor(p3);
        String result = p1.handle("Aren't lambdas really sexy");
        System.out.println("result = " + result);

        /* Using Lambdas */

        UnaryOperator<String> headerTextProcessing = (String input) -> "From Shiraz, Narayan and Kate " + input;
        UnaryOperator<String> xreplaceATextProcessing = (String input) -> input.replaceAll("a", "XX");
        UnaryOperator<String> tolowercaseTextProcessing = String::toLowerCase;

        Function<String, String> pipeline = headerTextProcessing.andThen(xreplaceATextProcessing).andThen(tolowercaseTextProcessing);
        result = pipeline.apply("Aren't lambdas really sexy");
        System.out.println("result = " + result);
    }
}
