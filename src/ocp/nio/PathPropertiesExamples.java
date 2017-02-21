package ocp.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class PathPropertiesExamples {
    public static void main(String[] args) {
        Path p = Paths.get("c:/home/java/workplace");

        System.out.println(p.getFileName());
        System.out.println(p.getParent());
        System.out.println(p.getFileSystem());
        System.out.println(p.getNameCount());
        System.out.println(p.getName(0));
        System.out.println(p.getName(1));
        System.out.println(p.getName(2));
        System.out.println(p.getRoot());
        System.out.println(p.subpath(0, 2)); //not including 2
        System.out.println(p.toString());
    }
}
