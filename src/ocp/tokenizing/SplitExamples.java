package ocp.tokenizing;

/**
 * Created by Madalin on 19/02/2017.
 */
public class SplitExamples {
    public static void main(String[] args) {
        String[] tokens = "la a23 a2 as.da2 5".split("\\d");
        for (String s: tokens) {
            System.out.println(s);
        }
    }
}
