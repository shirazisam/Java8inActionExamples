package patterns.chainofresponsibility;

/**
 * Created by shira on 10/12/2018.
 */
public class XreplaceATextProcessing extends ProcessingObject<String> {

    @Override
    public String handleWork(String input) {
        return input.replaceAll("a", "XX");
    }
}
