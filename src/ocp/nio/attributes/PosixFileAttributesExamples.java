package ocp.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 * 2 new attributes:
 *  - group
 *  - permissions
 */
public class PosixFileAttributesExamples {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("file1.txt");
        Files.createFile(p);
        PosixFileAttributes posixFileAttributes = Files.readAttributes(p, PosixFileAttributes.class);

        Set<PosixFilePermission> permissionSet = PosixFilePermissions.fromString("rwxrw-r");
        Files.setPosixFilePermissions(p, permissionSet);
        System.out.println(posixFileAttributes.permissions());
        System.out.println(posixFileAttributes.group());
    }
}
