package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class is responsible for load files with its path
 */
public class Utils {
    /**
     * This function reads a file from the specific path and returns a string of the file
     *
     * @param path the parameter of the path of the file
     * @return return the string of the file
     * @throws IOException throws exception if path is not reachable or correct
     */
    public static String loadResource(String path) throws IOException {
        return Files.readString(Path.of(path));
    }

}