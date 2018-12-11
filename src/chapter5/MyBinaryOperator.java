package chapter5;

/**
 * Created by shira on 15/11/2018.
 */
@FunctionalInterface
public interface MyBinaryOperator<U, R> {

    R apply(U x, U y);
}
