package patterns.strategy;

/**
 * Created by shira on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {

        Validator numericValidator = new Validator(new IsNumeric());
        Validator lowercaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        String number = "1238O45";
        System.out.println(number + " isNumeric: " + numericValidator.validate(number));
        String lowercaseStr = "abfdlskjdfr";
        System.out.println(lowercaseStr + " isAllLowercase: " + lowercaseValidator.validate(lowercaseStr));
    }
}
