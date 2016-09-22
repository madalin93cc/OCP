package ocp.assertions;

/**
 * Created by Madalin.Colezea on 9/20/2016.
 */
public class Assertions {
    static void noReturn() { }
    static int aReturn() { return 1; }
    public static void main(String[] args) {
        int x = 1;
        boolean b = true;
// the following six are legal assert statements
        assert(x == 1);
        assert(b);
        assert true;
        assert(x == 1) : x;
        assert(x == 1) : aReturn();
        assert(x == 1) : new Object();

// the following six are ILLEGAL assert statements
//        assert(x = 1); // none of these are booleans
//        assert(x);
//        assert 0;
//        assert(x == 1) : ; // none of these return a value
//        assert(x == 1) : noReturn();
//        assert(x == 1) : ValidAssert va;
// nu poate fi variabila
//        int assert = 2;

//        enable at runtime
//        java -ea a.class
//        java -enableassertions a.class

//        disanable at runtime
//        java -da a.class
//        java -disableassertions a.class

//        enable in general mai putin pachetul foo si celelalte subpachete
//        java -ea -da:com.foo...

//        clasa Bar
//        java -ea:com.foo.Bar
    }
}
