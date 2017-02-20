package ocp.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 * delete() - can not delete a directory if it is not empty -> returns false
 * renameTo() - it is possible to rename a directory even if it is not empty
 *            - receives a valid File as parameter
 *
 */
public class FileExamples {
    public static void main(String[] args) {
        boolean newFile = false;
        File file = new File("file1.txt");
        System.out.println(file.exists());
        try {
            newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFile);
        System.out.println(file.exists());
        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalFile());
            System.out.println(file.getCanonicalPath());
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(file.getTotalSpace());
        System.out.println(file.getFreeSpace());
        System.out.println(file.getUsableSpace());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.delete());
    }
}
