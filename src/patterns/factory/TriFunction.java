package patterns.factory;

/**
 * Created by shira on 10/12/2018.
 */
public interface TriFunction<T, U, V, R> {

    R apply(T t, U u, V v);

}
