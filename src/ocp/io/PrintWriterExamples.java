package ocp.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class PrintWriterExamples {
    public static void main(String[] args) {
        File file = new File("file4.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.write("asdadasd");
            pw.println();
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
