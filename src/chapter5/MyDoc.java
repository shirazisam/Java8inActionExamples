package chapter5;

import java.util.Optional;

/**
 * Created by shira on 13/11/2018.
 */
public class MyDoc {
    private long id;
    private String filename;

    public MyDoc(long id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public int hashCode() {
        return filename != null ? filename.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyDoc{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                '}';
    }
}
