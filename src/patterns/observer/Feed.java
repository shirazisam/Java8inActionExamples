package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shira on 10/12/2018.
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObservers(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
