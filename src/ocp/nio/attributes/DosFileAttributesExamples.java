package ocp.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 * 4 new attributes:
 *  - readonly
 *  - hidden
 *  - archive
 *  - system
 */
public class DosFileAttributesExamples {
    public static void main(String[] args) throws IOException{
        Path p = Paths.get("file1.txt");
        DosFileAttributes dosFileAttributes = Files.readAttributes(p, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isArchive());
        System.out.println(dosFileAttributes.isSystem());

        Files.setAttribute(p, "dos:readonly", true);
        Files.setAttribute(p, "dos:hidden", true);

        dosFileAttributes = Files.readAttributes(p, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println(dosFileAttributes.isHidden());

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(p, DosFileAttributeView.class);
        dosFileAttributeView.setReadOnly(false);
        dosFileAttributeView.setHidden(false);

        dosFileAttributes = Files.readAttributes(p, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println(dosFileAttributes.isHidden());
    }
}
