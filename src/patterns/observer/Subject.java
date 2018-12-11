package patterns.observer;

/**
 * Created by shira on 10/12/2018.
 */
public interface Subject {

    void registerObservers(Observer o);
    void notifyObservers(String tweet);
}
