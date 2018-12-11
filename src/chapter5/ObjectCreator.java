package chapter5;

import java.util.function.Supplier;

/**
 * Created by shira on 10/12/2018.
 */
public class ObjectCreator<T> {


    public T create(Supplier<T> supplier) {
        System.out.println(supplier + " created.");
        return supplier.get();
    }
}
