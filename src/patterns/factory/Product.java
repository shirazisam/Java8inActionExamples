package patterns.factory;

/**
 * Created by shira on 10/12/2018.
 */
public class Product {

    public Double price;
    public String name;
    public Integer year;

    public Product(Double price, String name, Integer year) {
        this.price = price;
        this.name = name;
        this.year = year;
    }
}
