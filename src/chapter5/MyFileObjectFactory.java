package chapter5;

import java.nio.file.Path;

/**
 * Created by shira on 26/11/2018.
 */
public class MyFileObjectFactory {


    public static MyFileObject newInstance(Path p) {
        return new MyFileObject(p);
    }
}
