package ocp.collections.innerclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 */
public class AnnonymousClassesExamples {
    public static void main(String[] args) {
        PopCorn popCorn = new PopCorn() {
            @Override
            public void pop() {
                System.out.println("Anonymous pop");
            }
        };

        popCorn.pop();

        // interface
        Comparator c = new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return 0;
            }
        };

        List<String> list = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
    }
}

class PopCorn {
    public void pop() {
        System.out.println("Pop");
    }
}
