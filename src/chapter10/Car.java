package chapter10;

import java.util.Optional;

/**
 * Created by shira on 29/11/2018.
 */
public class Car {

    Optional<Insurance> insurance = null;

    public Car() {
        insurance = Optional.empty();
    }

    public Car(Insurance ins) {
        insurance = Optional.ofNullable(ins);
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
