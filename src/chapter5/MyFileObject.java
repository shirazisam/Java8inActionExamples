package chapter5;

import java.nio.file.Path;

/**
 * Created by shira on 26/11/2018.
 */
public class MyFileObject {

    private Path path;

    public MyFileObject(Path p) {
        this.path = p;
    }

    @Override
    public String toString() {
        return getFilename();
    }

    public String getFilename() {
        return path.getFileName().toString().toUpperCase();
    }
}
