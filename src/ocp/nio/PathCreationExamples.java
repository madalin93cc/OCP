package ocp.nio;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class PathCreationExamples {
    public static void main(String[] args) {
        Path p1 = Paths.get("deldir\\file1_ren.txt");
        Path p2 = Paths.get("deldir", "file1_ren.txt");
        Path p3 = FileSystems.getDefault().getPath("delfir", "file1_ren.txt");
        Path p4 = Paths.get(URI.create("file:///C:/temp"));
    }
}
