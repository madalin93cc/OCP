package ocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 */
public class Q8 {
    public static void main(String[] args) {
//        ArrayList<Integer> input = null;
//        ArrayList<Integer> output = null;

        List<Integer> output = null;
        List<Integer> input = null;
//        List<Number> output = null;
//        List<Number> input = null;
        output = process(input);
    }

    public static <E extends Number>List<E> process(List<E> list) {
        return list;
    }
}
