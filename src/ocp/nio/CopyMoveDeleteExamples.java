package ocp.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class CopyMoveDeleteExamples {
    public static void main(String[] args) {
        copyExample();
        moveExample();
        deleteExample();
    }

    static void copyExample() {
        Path copy1 = Paths.get("copy1.txt");
        Path copy2 = Paths.get("copy2.txt");

        try {
            if (Files.notExists(copy1)) {
                Files.createFile(copy1);
            }
            Files.copy(copy1, copy2, StandardCopyOption.REPLACE_EXISTING); // NoSuchFileException if copy1 does not exista
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void moveExample() {
        Path copy1 = Paths.get("copy1.txt");
        Path copy2 = Paths.get("copy2.txt");

        try {
//            Files.move(copy1, copy2); // FileAlreadyExistsException if copy2 exists
            Files.move(copy1, copy2, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteExample() {
        Path del = Paths.get("copy2.txt");
        try {
//            Files.delete(Paths.get("copy1.txt")); // NoSuchFileException if file does not exists
            Files.deleteIfExists(del);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
