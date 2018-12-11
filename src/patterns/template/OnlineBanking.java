package patterns.template;

import data.Dish;
import data.Menu;

import java.util.function.Consumer;

/**
 * Created by shira on 10/12/2018.
 */
public abstract class OnlineBanking {

    public void processCustomer(String dishname) {
        System.out.println("OnlineBanking.processCustomer");
        Dish dish = Menu.getMenu().stream().filter(d -> dishname.equals(d.getName())).findFirst().orElse(Dish.UNKNOWN);
        makeCustomerHappy(dish);
    }

    abstract void makeCustomerHappy(Dish d);
}
