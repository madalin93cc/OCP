package ocp.generics;

import java.util.Date;

/**
 * Created by Madalin on 02/03/2017.
 * E = Element si e folosit pentru colectii
 * T = !Element
 */
public class GenericDeclarationExamples {
    public static void main(String[] args) {
        TestGenerics<Integer, String> testGenerics = new TestGenerics<>();
        System.out.println(testGenerics.setT(2, new Date()));
    }
}

class TestGenerics<T, X> {
    private T t;
    private X x;

    public T getT(){
        return t;
    }

    public <Z> Z setT(T t, Z z) {
        this.t = t;
        return z;
    }
}
