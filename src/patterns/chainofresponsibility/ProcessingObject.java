package patterns.chainofresponsibility;

/**
 * Created by shira on 10/12/2018.
 */
public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    public ProcessingObject<T> setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
        return successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    public abstract T handleWork(T input);
}
