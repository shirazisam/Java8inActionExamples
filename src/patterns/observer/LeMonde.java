package patterns.observer;


/**
 * Created by shira on 10/12/2018.
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Cheese and wine news " + tweet);
        }
    }
}
