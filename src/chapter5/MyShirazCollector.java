package chapter5;

import data.Dish;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * Created by shira on 27/11/2018.
 */
public class MyShirazCollector<T> implements java.util.stream.Collector<T, List<T>, List<T>> {
    @Override
    public Supplier<List<T>> supplier() {
        System.out.println("MyShirazCollector.supplier");
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        System.out.println("MyShirazCollector.accumulator");
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        System.out.println("MyShirazCollector.combiner");
        return (a,b) -> {
            a.addAll(b);
            return a;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        System.out.println("MyShirazCollector.finisher");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("MyShirazCollector.characteristics");
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
    }
}
