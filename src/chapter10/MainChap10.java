package chapter10;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;

/**
 * Created by shira on 29/11/2018.
 */
public class MainChap10 {

    static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap((person1) -> person1.getCar())
                .flatMap((car) -> car.getInsurance())
                .map((insurance) -> insurance.getName())
                .orElseGet(() -> "Unknown");
    }

    static Optional<Insurance> findCheapestInsurance(Person person, Car car) {
        return Optional.empty();
    }

    static Optional<Insurance> findCheapestInsuranceNullSafe(Optional<Person> person, Optional<Car> car) {
        person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c))); // ? cannot return this //
        return Optional.empty();
    }

    static void whenInitializeUnmodifiableSetWithoutDoubleBrace_containsElements() {
        Set<String> countries = Stream.of("India", "USSR", "USA")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));

        System.out.println("countries = " + countries);
    }

    public int readDuration(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap((s) -> OptionalUtility.stringToInt(s))
                .filter(i -> i > 0)
                .orElse(0);
    }

    public int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) { }
        }
        return 0;
    }

    public static void main(String[] args) {

        Insurance insurance = new Insurance("SWORD Ltd");
        Car car = new Car(insurance);
        Person person = new Person(car);

        Optional<Insurance> insuranceOptional = Optional.of(insurance);

        insuranceOptional.filter(ins -> "SWORD Ltd".equals(ins.getName())).ifPresent(x -> System.out.println("OK"));

        String insName = getCarInsuranceName(Optional.ofNullable(person));


        System.out.println("insName = " + insName);

        Person pp = new Person() {
            @Override
            public Person add(String s) {
                System.out.println("shite " + s);
                return this;
            }
            // this is an anti-pattern
            {
            add("one");
            add("two");
            add("three");
        }};

        Person pp2 = new Person().add("four").add("five").add("six");

        whenInitializeUnmodifiableSetWithoutDoubleBrace_containsElements();

        List<String> list = Arrays.asList("India", "USSR", "USA");

        Double aDouble = OptionalUtility.sqrt(2.0).orElseThrow(IllegalArgumentException::new);
        System.out.println("aDouble = " + aDouble);
    }
}
