package chapter5;

/**
 * Created by shira on 11/11/2018.
 */
public class Repository<T> {

    public void save(T t) {
        System.out.println(t + " saved.");
    }
}
