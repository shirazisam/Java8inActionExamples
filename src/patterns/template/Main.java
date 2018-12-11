package patterns.template;

import data.Dish;

/**
 * Created by shira on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {

        OnlineBanking banking = new OnlineBankingKBC();
        banking.processCustomer("salmon");

        OnlineBankingLambda onlineBankingLambda = new OnlineBankingLambda();
        onlineBankingLambda.processCustomer("pizza", (Dish d) -> System.out.println("lambda1 = " + d));
        onlineBankingLambda.processCustomer("chicken", (Dish d) -> System.out.println("lambda2 = " + d));
    }
}
