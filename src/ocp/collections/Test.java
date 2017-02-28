package ocp.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Madalin.Colezea on 2/27/2017.
 */
public class Test {
    public static void main(String[] args) {
        List<ArrayList> list = new ArrayList<>();
        list.add(new ArrayList() {{add(2);}});
        System.out.println(list.contains(new LinkedList() {{add(2);}}));
    }
}
