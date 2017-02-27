package ocp.collections;

/**
 * Created by Madalin on 26/02/2017.
 * Override only when makes sense that two different objects to be equals
 * Must be override when used as key for HashTable
 * Equals in Object uses == for comparision
 * Contract:
 *  - reflexive -> x.equals(x) = true
 *  - symmetric -> x.equals(y) <=> y.equals(x)
 *  - transitive: x.equals(y) = true && y.equals(z) = true -> x.equals(x) = true
 *  - consistent
 *  - for any non null x : x.equals(null) = false
 *  - if 2 objects are equal then they must have the same hash value
 */
public class EqualsExamples {
    public static void main(String[] args) {
        A a = new A("2");
        A b = new A("2");
        System.out.println(a.equals(b));
    }
}

class A {
    String value;

    public A(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof A) && ((A)o).getValue().equals(this.getValue())) {
            return true;
        } else {
            return false;
        }
    }
}
