package chapter11;

/**
 * Created by shira on 03/12/2018.
 */
@FunctionalInterface
public interface MyBiFunction<U, V, R> {

    R apply(U u, V v);
}
