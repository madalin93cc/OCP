package ocp.innerclasses;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 */
public class StaticNestedClassesExamples {
    public static void main(String[] args) {
        BigOuter.C1 c1 = new BigOuter.C1();
        c1.go();
        C2 c2 = new C2();
        c2.go();
    }
}

class BigOuter {
    static class C1 {
        void go() {
            System.out.println("hi");
        }
    }
}

class C2 {
    static class C3 {
        void go() {
            System.out.println("hi1");
        }
    }

    void go() {
        C3 c3 = new C3();
        c3.go();
    }
}