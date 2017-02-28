package ocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class NewOldExamples {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        Test test = new Test();
        test.add(integers);
        test.insInt(integers);
        test.insStr(integers);
        System.out.println(integers);

        List ints = new ArrayList();
        int a = (int)ints.get(2);
        Integer x = integers.get(2);
    }


}

class Test {
    void add(List integers) {
        System.out.println(integers);
    }

    void insStr(List integers) {
        integers.add("Str");
    }

    void insInt(List integers) {
        integers.add(3);
    }
}
