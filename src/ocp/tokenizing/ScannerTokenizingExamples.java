package ocp.tokenizing;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Madalin on 19/02/2017.
 */
public class ScannerTokenizingExamples {
    public static void main(String[] args) {
        simpleTest();
        complexTest();
    }

    static void simpleTest() {
        Scanner s = new Scanner("asda asd 2 2dasd asdk 21 23sda ");
//        s.useDelimiter(Pattern.compile("\\d"));

        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

    static void complexTest() {
        Scanner s = new Scanner("asda asd 2 2dasd true asdk 21 23sda ");
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                int i = s.nextInt();
                System.out.println("int: " + i);
            } else if (s.hasNextBoolean()) {
                boolean b = s.nextBoolean();
                System.out.println("bool: " + b);
            } else {
                String s2 = s.next();
                System.out.println("str: " + s2);
            }
        }
    }
}
