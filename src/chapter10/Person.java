package chapter10;

import java.util.Optional;

/**
 * Created by shira on 29/11/2018.
 */
public class Person {

    Optional<Car> car = null;

    public Person() {
        car = Optional.empty();
    }

    public Person(Car c) {
        car = Optional.ofNullable(c);
    }

    public Optional<Car> getCar() {
        return car;
    }

    public Person add(String s) {
        System.out.println("ADD: s = " + s);
        return this;
    }
}
