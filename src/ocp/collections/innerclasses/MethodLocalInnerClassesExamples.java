package ocp.collections.innerclasses;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 * Poate fi instantiata doar in interiorul metodei
 */
public class MethodLocalInnerClassesExamples {
    private int x;
    private static int s;

    public void doStuff() {
//        Inner1 inner1 = new Inner1(); // nu stie
        class Inner1 {
            public void doStuff() {
                System.out.println("Outer x: " + x);
            }
        }
        Inner1 inner1 = new Inner1();
        inner1.doStuff();
    }

    public void doStuffParameters(final int x) {
        int y = 2;
        final int z = 2;
        class Inner1 {
            public void doStuff() {
                System.out.println(x);
//                System.out.println(y);
                System.out.println(z);
            }
        }
    }

    public static void doStuffStatic2() {
        int y = 2;
        final int z = 2;
        class Inner1 {
            public void doStuff() {
//                System.out.println(x); // nu are acces
                System.out.println(s);
//                System.out.println(y);
                System.out.println(z);
            }
        }
    }

    public static void doStuffStatic() {
        class Inner1 {
            public void doStuff() {
                System.out.println("Static");
            }
        }
        Inner1 inner1 = new Inner1();
        inner1.doStuff();
    }

    public static void main(String[] args) {
        new MethodLocalInnerClassesExamples().doStuff();
        MethodLocalInnerClassesExamples.doStuffStatic();
    }
}
