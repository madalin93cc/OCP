package ocp.tokenizing;

import java.util.StringTokenizer;

/**
 * Created by Madalin on 19/02/2017.
 */
public class StringTokenizerExamples {
    public static void main(String[] args) {
        StringTokenizer s = new StringTokenizer("ab asd a sadas sada aa ds");
        System.out.println(s.countTokens());
        while (s.hasMoreTokens()) {
            System.out.println(s.nextToken());
        }
        System.out.println(s.countTokens());

        StringTokenizer s2 = new StringTokenizer("ab asd a sadas sada aa ds", "a");
        System.out.println(s2.countTokens());
        while (s2.hasMoreTokens()) {
            System.out.println(s2.nextToken());
        }
        System.out.println(s2.countTokens());
    }
}
