package ocp.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Madalin.Colezea on 1/13/2017.
 */
public class RegexExamples {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("ab");
//        Matcher m = p.matcher("abaaaba");
        Pattern p = Pattern.compile("aba");
        Matcher m = p.matcher("abababa"); // caracterele se folosesc intr-un singur match (nu se refoloseste)
        System.out.print("Matches: ");
        while (m.find()) {
            System.out.print(m.start() + " ");
        }
    }

}
