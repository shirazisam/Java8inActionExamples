package patterns.template;

import data.Dish;
import data.Menu;

/**
 * Created by shira on 10/12/2018.
 */
public class OnlineBankingKBC extends OnlineBanking {

    @Override
    void makeCustomerHappy(Dish dish) {
        System.out.println("OnlineBankingKBC.makeCustomerHappy + " + dish);
    }
}
