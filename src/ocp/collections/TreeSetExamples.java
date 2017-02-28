package ocp.collections;

import java.util.TreeSet;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class TreeSetExamples {
    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(123);
        integers.add(4123);
        integers.add(256);
        integers.add(8643);
        System.out.println(integers);
        System.out.println(integers.lower(4123));
        System.out.println(integers.floor(4123));
        System.out.println(integers.higher(4123));
        System.out.println(integers.ceiling(4123));
        System.out.println(integers.first());
        System.out.println(integers.last());
        System.out.println(integers.headSet(4123, true));
        System.out.println(integers.tailSet(4123));
        System.out.println(integers.descendingSet());
        System.out.println(integers.pollFirst());
        System.out.println(integers.pollLast());
    }
}
