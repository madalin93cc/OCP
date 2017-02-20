package ocp.io;

import java.io.Console;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class ConsoleExamples {
    public static void main(String[] args) {
        Console c = System.console();
        char[] password;
        password = c.readPassword("$s", "pw: ");
        for (char ch: password) {
            c.format("%c ", ch);
        }
        c.format("\n");
        String name = "";
        while (true) {
            name = c.readLine("$s", "input?: ");
            c.format("output: %s\n", name);
        }
    }
}
