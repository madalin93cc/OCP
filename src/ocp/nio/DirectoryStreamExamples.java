package ocp.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 * Access only one directory
 * Works like dir or ls command
 */
public class DirectoryStreamExamples {
    public static void main(String[] args) throws IOException{
        Path dir = Paths.get("deldir");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(dir, "*[1]*")) {
            for (Path p: directoryStream) {
                System.out.println(p.getFileName());
            }
        }
    }
}
