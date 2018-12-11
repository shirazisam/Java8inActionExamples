package patterns.chainofresponsibility;

/**
 * Created by shira on 10/12/2018.
 */
public class TolowercaseTextProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String input) {
        return input.toLowerCase();
    }
}
