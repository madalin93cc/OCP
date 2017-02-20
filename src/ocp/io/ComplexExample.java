package ocp.io;

import java.io.File;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class ComplexExample {
    public static void main(String[] args) {
        File dir = new File("deldir");
        System.out.println(dir.mkdir());
        try {
            File file1 = new File(dir, "file1.txt");
            file1.createNewFile();
            File file2 = new File(dir, "file2.txt");
            file2.createNewFile();
            if (dir.isDirectory()) {
                String [] files = dir.list();
                for (String s: files) {
                    System.out.println(s);
                }
//                System.out.println(file1.delete());
                System.out.println(file1.renameTo(new File(dir, "file1_ren.txt")));
//                System.out.println(file2.delete());
                System.out.println(file2.renameTo(new File(dir, "file2_ren.txt")));
                System.out.println(file1.delete());
                System.out.println(file2.delete());
                file1 = new File("file1_ren.txt");
                System.out.println(file1.delete());
                file2 = new File("file2_ren.txt");
                System.out.println(file2.delete());
                files = dir.list();
                for (String s: files) {
                    System.out.println(s);
                }
            }

        } catch (Exception e) {
         e.printStackTrace();
        }

    }
}
