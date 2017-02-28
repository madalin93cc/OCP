package ocp.collections;

/**
 * Created by Madalin.Colezea on 2/27/2017.
 * Wrapper classes are immutable
 * Two wrapper objects are equal if are of the same type and have the same value
 * Clase pentru care == va fi true cand primitivele lor au aceleasi valori (optimizare memorie):
 *  - Boolean
 *  - Byte
 *  - Character from \u0000 \u007f (127)
 *  - Short and Integer from -128 to 127
 */
public class AutoboxingExamples {
    public static void main(String[] args) {
        Integer x = 500;
        Integer y = x;
        System.out.println(x == y);
        x++;
        System.out.println(x + " " + y);
        System.out.println(x == y);

        //

        Integer i1 = 1000;
        Integer i2 = 1000;
        System.out.println(i1 != i2);
        System.out.println(i1.equals(i2));

        Integer i3 = 10;
        Integer i4 = 10;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        Integer z = null;
        doStuf(z);
    }

    private static void doStuf(int x) {
//        NullPointer due to unboxing of null
        System.out.println(x);
    }
}
