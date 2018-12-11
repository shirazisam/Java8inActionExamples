package chapter10;

import java.util.Optional;

/**
 * Created by shira on 01/12/2018.
 */
public class OptionalUtility {
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public static Optional<Double> sqrt(Double n) {

        Double sqrt = Math.sqrt(n);

        return Double.isNaN(sqrt) ? Optional.empty() : Optional.of(sqrt);
    }
}
