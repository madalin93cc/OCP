package ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 * path1.relativize(path2) = give me a path that shows how to get from path1 to path2
 */
public class RelativizingExamples {
    public static void main(String[] args) {
        System.out.println(Paths.get("/home/java").relativize(Paths.get("/home/java/music/a.mp3")));

        Path absolute1 = Paths.get("/home/java");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/java/temp/music.mp3");
        Path relative1 = Paths.get("temp");
        Path relative2 = Paths.get("temp/music.pdf");
        Path relative3 = Paths.get("java/music.pdf");

        System.out.println(absolute1.relativize(absolute3));
        System.out.println(absolute3.relativize(absolute1));
        System.out.println(absolute1.relativize(absolute2));
        System.out.println(relative1.relativize(relative2));
        System.out.println(relative1.relativize(relative3)); // not so good
//        System.out.println(absolute1.relativize(relative1)); // bad
    }
}
