package patterns.observer;


/**
 * Created by shira on 10/12/2018.
 */
public class Guadrian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in london " + tweet);
        }
    }
}
