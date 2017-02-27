package ocp.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Madalin on 27/02/2017.
 */
public class ConvertingExamples {
    public static void main(String[] args) {
        String [] sa = {"A", "B", "C"};
        List aList = Arrays.asList(sa);
        System.out.println(aList.size());
        System.out.println(aList);
        aList.set(2, "X");
        sa[0] = "Y";
        System.out.println(aList);
        System.out.println(Arrays.toString(sa));


        List<Integer> ints = new ArrayList() {{add(1); add(2); add(3);}};
        Object[] oa = ints.toArray();
        Integer[] ia = new Integer[3];
        ia = ints.toArray(ia);
        oa[0] = 5;
        ia[1] = 6;
        ints.set(2, 7);
        System.out.println(ints);
        System.out.println(Arrays.toString(oa));
        System.out.println(Arrays.toString(ia));
    }
}
