package chapter5;

import java.util.function.IntBinaryOperator;

/**
 * Created by shira on 15/11/2018.
 */
@FunctionalInterface
public interface MyIntTrinaryOperator {

    int applyAsInt(int x, int y);
}
