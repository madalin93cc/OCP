package ocp.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Madalin.Colezea on 1/13/2017.
 *  \d A digit (0–9)
    \D A non-digit (anything BUT 0–9)
    \s A whitespace character (e.g. space, \t, \n, \f, \r)
    \S A non-whitespace character
    \w A word character (letters (a–z and A–Z), digits, or the "_" [underscore])
    \W A non-word character (everything else)
    \b A word "boundary" (ends of the string and between \w and not -> al 2 lea element dintr-o pereche de 2 word cu non-word alaturate
    \w—more soon)
    \B A non-word "boundary" (between two \w's or two not \w's) -> al 2 lea element dintr-o pereche de 2 word cu word sau non-word cu non-word alaturate
    Ranges
    [abc] Searches only for a's, b's, or c's
    [a-f] Searches only for a, b, c, d, e, or f characters
    [a-fA-F] Searches for the first six letters of the alphabet, both cases
    Quantifiers
    + one or more
    * zero or more occurences
    ? zero or one occurence
    . match any character
    +? reluctant
    *? reluctant
    ?? reluctant
    \n = linefeed (which you might see on the exam)
    \b = backspace
    \t = tab
 */
public class RegexExamples {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("ab");
//        Matcher m = p.matcher("abaaaba");
//        Pattern p = Pattern.compile("aba");
//        Matcher m = p.matcher("abababa"); // caracterele se folosesc intr-un singur match (nu se refoloseste)
//        Pattern p = Pattern.compile("\\d");
//        Matcher m = p.matcher("1asd2ra456");
//        Pattern p = Pattern.compile("\\s");
//        Matcher m = p.matcher("1asd2r\ta456");
//        Pattern p = Pattern.compile("\\b");
//        Matcher m = p.matcher("w2w w$ &#w2");
//        Pattern p = Pattern.compile("\\b");
//        Matcher m = p.matcher("#ab de#");
//        Pattern p = Pattern.compile("\\B");
//        Matcher m = p.matcher("#ab de#");
//        Pattern p = Pattern.compile("[abc]");
//        Matcher m = p.matcher("#ab asdcaawewfdade#");
//        Pattern p = Pattern.compile("[a-f]");
//        Matcher m = p.matcher("#ab asdcaawewfdade#");
//        Pattern p = Pattern.compile("[a-fA-F]");
//        Matcher m = p.matcher("#ab asdcaawewfdade#AF");
//        Pattern p = Pattern.compile("[(a-f)(A-F)( )]"); // union
//        Matcher m = p.matcher("#ab asdcaawewfdade#AF ");
//        Pattern p = Pattern.compile("[(a-f)&&(f-i)]"); // intersection
//        Matcher m = p.matcher("#fab asdcaawewfdade#AF ");
//        Pattern p = Pattern.compile("[^abc]"); // negation
//        Matcher m = p.matcher("#fab asdcaawewfdade#AF ");
//        Pattern p = Pattern.compile("0[xX][0-1a-fA-F]");
//        Matcher m = p.matcher("12 0x 0x12 0Xf 0xg");
//        Pattern p = Pattern.compile("\\d+");
//        Matcher m = p.matcher("1 a12 234b");
//        Pattern p = Pattern.compile("0[xX]([0-1a-fA-F])?");
//        Matcher m = p.matcher("12 0x 0x123 0Xf 0xg");
//        Pattern p = Pattern.compile("proj1([^,])*");
//        Matcher m = p.matcher("proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java");
//        Pattern p = Pattern.compile("\\d\\d\\d([\\s-])?\\d\\d\\d\\d");
//        Matcher m = p.matcher("123 4567");
//        Pattern p = Pattern.compile("a.c");
//        Matcher m = p.matcher("abc a c");
//        Pattern p = Pattern.compile(".*xx");
//        Matcher m = p.matcher("abxxyabxx");
//        Pattern p = Pattern.compile(".*?xx"); // reluctant
//        Matcher m = p.matcher("abxxyabxx");
        Pattern p = Pattern.compile(".*\\."); // search for . character
        Matcher m = p.matcher("aaa.");

        System.out.println("Matches: ");
        while (m.find()) {
            System.out.println(m.start() + " " + m.group());
        }
    }

}
