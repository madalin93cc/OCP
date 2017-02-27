package ocp.collections.searching;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Madalin on 27/02/2017.
 */
public class SearchExamples {
    public static void main(String[] args) {
        String [] strings = new String[] {"A", "Z", "D"};
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.binarySearch(strings, "Z"));
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.binarySearch(strings, "Z"));
        Rev rev = new Rev();
        Arrays.sort(strings, rev);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.binarySearch(strings, "Z"));
        System.out.println(Arrays.binarySearch(strings, "Z", rev));
    }
}

class Rev implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}