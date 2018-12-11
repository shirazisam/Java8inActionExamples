package patterns.factory;

/**
 * Created by shira on 10/12/2018.
 */
public class Bond extends Product {

    public Bond(Double price, String name, Integer year) {
        super(price, name, year);
        System.out.println("price = [" + price + "], name = [" + name + "], year = [" + year + "]");
    }

}
