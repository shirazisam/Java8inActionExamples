package chapter5;

import data.Dish;
import data.Menu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Created by shira on 02/11/2018.
 */
public class Main {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public Main() {
        System.out.println("Main.Main");
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //  Find all transactions in 2011 and sort by value (small to high)
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

        // all the unique cities where the traders work
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

        // all the unique cities where the traders work
        transactions.stream()
                // sorted(Comparator.comparing(Transaction::getValue))
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        // all traders from Cambridge and sorted by name
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        // Return a string of all traders’ names sorted alphabetically
        String allnames = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());

        Optional<Trader> milan = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();

        // Are any traders based in Milan?
        boolean milan1 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        // Print all transactions’ values from the traders living in Cambridge
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // What’s the highest value of all the transactions?
        Integer max = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println("max = " + max);

        // Find the transaction with the smallest value
        Optional<Transaction> smallest = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("min = " + smallest);
        // or
        smallest = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println("min = " + smallest);

        int z = doBinaryStuff(4, 5, (x, y) -> x * y);
        System.out.println("z = " + z);
        z = doBinaryStuff(4, 3, (x, y) -> (int) Math.pow(x, y));
        System.out.println("z = " + z);

        Map<Dish.Type, List<Dish>> dishesByType = Menu.getMenu().stream().collect(groupingBy(Dish::getType));
        System.out.println("dishesByType = " + dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCalories = Menu.getMenu().stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        System.out.println("dishesByCalories = " + dishesByCalories);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCalories = Menu.getMenu().stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(Dish::getCaloricLevel)
                )
        );
        System.out.println("dishesByTypeCalories = " + dishesByTypeCalories);

        Map<Dish.Type, Long> typesCount = Menu.getMenu().stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println("typesCount = " + typesCount);

        // lowest caloric food in each group
        Map<Dish.Type, Dish> dishMap = Menu.getMenu().stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                minBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = Menu.getMenu().stream().collect(
                groupingBy(Dish::getType, mapping(
                        d -> {
                            if (d.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toCollection(HashSet::new))
                ));
        System.out.println("caloricLevelByType = " + caloricLevelByType);

        Map<Boolean, List<Integer>> partitionByPrime = IntStream.rangeClosed(2, 30)
                .boxed()
                .collect(partitioningBy(n -> isPrime(n)));

        System.out.println("partitionByPrime = " + partitionByPrime);

        ObjectCreator<Double> objectCreator = new ObjectCreator<>();

        Double bla = objectCreator.create(() -> Math.sqrt(2.0));
        System.out.println("bla = " + bla);
    }

    static int doBinaryStuff(int arg1, int arg2, MyIntTrinaryOperator operator) {
        return operator.applyAsInt(arg1, arg2);
    }

    static boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, (int) Math.sqrt((double)candidate)).noneMatch(i -> candidate % i == 0);
    }

}
