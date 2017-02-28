package ocp.collections;

import java.util.*;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class SetExamples {
    public static void main(String[] args) {
        boolean [] bo = new boolean[5];

        Set set = new HashSet();
//        Set set = new TreeSet(); // eroare la executie
        bo[0] = set.add("a");
        bo[1] = set.add(new Integer(32));
        bo[2] = set.add("b");
        bo[3] = set.add("a");
        bo[4] = set.add(new Object());

        for (boolean b: bo) {
            System.out.println(b + " ");
        }

        for (Object o: set) {
            System.out.println(o);
        }

        TreeSet<String> backed = new TreeSet<>();
        backed.add("a");
        backed.add("b");
        backed.add("f");
        SortedSet<String> sub = backed.subSet("b", "e");
        System.out.println(backed);
        System.out.println(sub);
        backed.add("c");
        backed.add("f");
        sub.add("d");
//        sub.add("g"); // exception: key out of range
        System.out.println(backed);
        System.out.println(sub);
    }
}
