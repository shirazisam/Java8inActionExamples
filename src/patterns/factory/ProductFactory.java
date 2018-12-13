package patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

/**
 * Created by shira on 10/12/2018.
 */
public class ProductFactory {

    /* A factory pattern using lambda - pushed ** MASTER ** */

    final static Map<String, TriFunction<Double, String, Integer, Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String name, double price, int year) {
        TriFunction<Double, String, Integer, Product> function = map.get(name);
        if (function != null) {
            return function.apply(price, name, year);  // invokes the constructor reference
        }
        throw new NoSuchElementException(String.format("nonexistent product '%s'", name));
    }
}
