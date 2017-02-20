package ocp.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class FileWriter_ReaderExamples {
    public static void main(String[] args) {
        File file = new File("file2.txt");
        char[] chars = new char[50];
        try {
            System.out.println(file.exists());
            FileWriter fw = new FileWriter(file);
            fw.write("howdy\nfolks\n");
            fw.flush();
            fw.close();
            System.out.println(file.exists());
            FileReader fr = new FileReader(file);
            int size = fr.read(chars);
            System.out.println(size);
            for (char c: chars) {
                System.out.print(c);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
