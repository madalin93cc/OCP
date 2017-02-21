package ocp.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class BasicFileAttributesExamples {
    public static void main(String[] args) throws IOException {
        read();
        update();
    }

    static void read() throws IOException {
        Path p = Paths.get("file1.txt");
        if (Files.notExists(p))
            Files.createFile(p);
        BasicFileAttributes basicFileAttributes = Files.readAttributes(p, BasicFileAttributes.class);
        System.out.println(basicFileAttributes.creationTime());
        System.out.println(basicFileAttributes.lastAccessTime());
        System.out.println(basicFileAttributes.lastModifiedTime());
        System.out.println(basicFileAttributes.isDirectory());
        System.out.println(basicFileAttributes.size());
    }

    static void update() throws IOException {
        Path p = Paths.get("file1.txt");
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(p, BasicFileAttributeView.class);
        basicFileAttributeView.setTimes(null, FileTime.fromMillis(new Date().getTime()), null);

        System.out.println(basicFileAttributeView.readAttributes().lastAccessTime());
    }
}
