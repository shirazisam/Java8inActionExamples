package patterns.observer;

/**
 * Created by shira on 10/12/2018.
 */
public class Main {

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObservers(new Guadrian());
        f.registerObservers(new LeMonde());

        f.registerObservers((String tweet) -> {
            if (tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
        f.notifyObservers("A new stinky French cheese is to be launched with a well known wine tomorrow");
        f.notifyObservers("Sudden spike in BTC means the money will be pooled to other resources");
    }
}
