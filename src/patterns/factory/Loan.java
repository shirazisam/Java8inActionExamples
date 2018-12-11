package patterns.factory;

/**
 * Created by shira on 10/12/2018.
 */
public class Loan extends Product {


    public Loan(Double price, String name, Integer year) {
        super(price, name, year);
        System.out.println("price = [" + price + "], name = [" + name + "], year = [" + year + "]");;
    }
}
