package patterns.strategy;

/**
 * Created by shira on 10/12/2018.
 */
public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String a) {
        return a.matches("[0-9]+");
    }
}
