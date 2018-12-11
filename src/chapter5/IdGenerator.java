package chapter5;

import java.util.UUID;

/**
 * Created by shira on 13/11/2018.
 */
public class IdGenerator {

    private static long firstId = UUID.randomUUID().getLeastSignificantBits();

    public static long get() {
        return firstId++;
    }
}
