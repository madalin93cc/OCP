package ocp.collections;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 */
public class Q16 {
    public static void main(String[] args) {
        OtStr otStr = new OtStr();
        String[] arr = {"map", "pem", "marble", "key"};
        Arrays.sort(arr, otStr);
        for (String s: arr) {
            System.out.print(s + " ");
        }

        System.out.println(Arrays.binarySearch(arr, "map"));
        System.out.println(Arrays.binarySearch(arr, "map", otStr));
    }

    public static class OtStr implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    }
}
