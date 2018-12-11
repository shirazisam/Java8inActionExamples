package chapter5;

/**
 * Created by shira on 21/11/2018.
 */
public class MyWrapper<T> {

    T t;

    T doSomething() {
        System.out.println("hiiii");
        return t;
    }

}
