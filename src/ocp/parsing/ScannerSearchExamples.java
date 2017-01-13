package ocp.parsing;

import java.util.Scanner;

/**
 * Created by Madalin.Colezea on 1/13/2017.
 */
public class ScannerSearchExamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String token;
        System.out.flush();
        do {
            token = scanner.findInLine("\\d\\d");
            System.out.println(token);
        } while (token != null);
    }
}
