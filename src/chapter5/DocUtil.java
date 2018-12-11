package chapter5;

import java.nio.file.Path;
import java.util.Optional;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by shira on 11/11/2018.
 */
public class DocUtil {

    public static Optional<String> getFilenameWithoutExtension(Path p) {
        String filename = p.getFileName().toString();
        return Optional.of(FilenameUtils.removeExtension(filename));
    }
}
