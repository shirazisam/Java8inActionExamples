package patterns.template;

import data.Dish;
import data.Menu;

import java.util.function.Consumer;

/**
 * Created by shira on 10/12/2018.
 */
public class OnlineBankingLambda {

    public void processCustomer(String dishname, Consumer<Dish> makeCustomerHappy) {
        System.out.println("OnlineBankingLambda.processCustomer");
        Dish dish = Menu.getMenu().stream().filter(d -> dishname.equals(d.getName())).findFirst().orElse(Dish.UNKNOWN);
        makeCustomerHappy.accept(dish);
    }
}
