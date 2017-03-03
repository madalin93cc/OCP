package ocp.collections.innerclasses;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 * Definite in interiorul altei clase ca membru, nonstatice
 * Nu poate avea membrii statici de niciun fel
 * Pot fi accesate, instantiate doar prin instante ale clasei externe, fara exceptii
 */
public class RegularInnerClassesExamples {
    private int x;
    private static int y;

    public RegularInnerClassesExamples() {

    }
    public RegularInnerClassesExamples(int x) {
        this.x = x;
    }

    public void makeInner() {
        Inner1 inner1 = new Inner1();
        inner1.seeOuter();
    }

//    does not wrk -> no instance
    public static void makeInnerStatic() {
//        Inner1 inner1 = new Inner1();
        Inner1 inner11 = new RegularInnerClassesExamples(3).new Inner1();
//        inner1.seeOuter();
        inner11.seeOuter();
    }

    @Override
    public String toString() {
        return "RegularInnerClassesExamples{" +
                "x=" + x +
                '}';
    }

    class Inner1 {
        public void seeOuter() {
            System.out.println("Outer x: " + x);
            System.out.println("Outer y: " + y);
            System.out.println("Inner class: " + this);
            System.out.println("Outer class: " + RegularInnerClassesExamples.this);
        }
    }

    public static void main(String[] args) {
        RegularInnerClassesExamples.Inner1 inner1 = new RegularInnerClassesExamples().new Inner1();
        RegularInnerClassesExamples.Inner1 inner2 = new RegularInnerClassesExamples(2).new Inner1();
        inner1.seeOuter();
        inner2.seeOuter();
        RegularInnerClassesExamples.makeInnerStatic();
    }
}
