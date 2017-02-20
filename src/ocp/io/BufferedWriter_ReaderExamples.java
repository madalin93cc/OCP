package ocp.io;

import java.io.*;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class BufferedWriter_ReaderExamples {
    public static void main(String[] args) {
        File file = new File("file3.txt");
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("lala");
            bw.newLine();
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
