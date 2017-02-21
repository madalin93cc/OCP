package ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class ResolvingExamples {
    public static void main(String[] args) {
        Path absolute = Paths.get("/home/java");
        Path relative = Paths.get("dir");
        Path file = Paths.get("File.pdf");

        System.out.println(absolute.resolve(relative));
        System.out.println(absolute.resolve(file));
        System.out.println(relative.resolve(file));
        System.out.println(relative.resolve(absolute)); //bad
        System.out.println(file.resolve(absolute)); // bad
        System.out.println(file.resolve(relative)); // bad
        // System.out.println(absolute.resolve(null)); // ambiguous method call
    }
}
