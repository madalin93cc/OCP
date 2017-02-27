package ocp.collections.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Madalin on 27/02/2017.
 */
public class CollectionsSortExamples {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("D");
        list.add("A");
        list.add("X");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
