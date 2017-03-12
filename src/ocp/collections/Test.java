package ocp.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Madalin.Colezea on 2/27/2017.
 */
public class Test {
    public static void main(String[] args) {
        List<ArrayList> list = new ArrayList<>();
        list.add(new ArrayList() {{add(2);}});
        System.out.println(list.contains(new LinkedList() {{add(2);}}));
        List l = new CopyOnWriteArrayList();
        l.add(null);
        new ArrayList<Integer>() {{add(null); add(null);}};
        Map m = new ConcurrentHashMap<>();
        m.put(2, null);
        String s = "";
    }
}
