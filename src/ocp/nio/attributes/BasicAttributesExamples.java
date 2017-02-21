package ocp.nio.attributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class BasicAttributesExamples {
    public static void main(String[] args) throws IOException {
        old();
        nio();
    }

    static void old() throws IOException {
        File f = new File("file_att.txt");
        f.createNewFile();
        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.canExecute());
        System.out.println(f.lastModified());
        f.setLastModified(new Date().getTime());
        System.out.println(f.lastModified());
    }

    static void nio() throws IOException {
        Path p = Paths.get("file_att.txt");
        System.out.println(Files.isReadable(p));
        System.out.println(Files.isWritable(p));
        System.out.println(Files.isExecutable(p));
        System.out.println(Files.getLastModifiedTime(p));
        FileTime ft = FileTime.fromMillis(new Date().getTime());
        System.out.println(Files.getLastModifiedTime(p));
    }
}
