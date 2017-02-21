package ocp.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class CreatingFilesAndDirectoriesExamples {
    public static void main(String[] args) {
        createFile();
        createDirectory();
        createDirectories();
    }

    static void createFile() {
        Path p1 = Paths.get("path1.txt");
        System.out.println(Files.exists(p1));
        try {
            if (Files.notExists(p1))
                Files.createFile(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Files.exists(p1));
    }

    static void createDirectory() {
        Path dir = Paths.get("pathdir");
        System.out.println(Files.exists(dir));
        try {
            if (Files.notExists(dir))
                Files.createDirectory(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Files.exists(dir));
    }

    static void createDirectories() {
        Path dirs = Paths.get("pathdir", "subdir");
        System.out.println(Files.exists(dirs));
        try {
            if (Files.notExists(dirs)) {
                Files.createDirectories(dirs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Files.exists(dirs));
    }
}
