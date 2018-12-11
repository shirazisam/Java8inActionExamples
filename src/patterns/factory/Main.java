package patterns.factory;

/**
 * Created by shira on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {

        Product bond = ProductFactory.createProduct("bond", 250.0, 2017);
        Product stock = ProductFactory.createProduct("stock", 128.0, 2015);
        Product loan = ProductFactory.createProduct("loan", 402.0, 2018);
        Product share = ProductFactory.createProduct("share", 402.0, 2018);
    }
}
