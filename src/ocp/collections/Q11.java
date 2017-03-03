package ocp.collections;

/**
 * Created by Madalin.Colezea on 3/3/2017.
 */
public class Q11 {
    public static void main(String[] args) {

    }
}

class Turtle {
    int size;
    public Turtle(int s) {
        size = s;
    }

    public boolean equals(Object o) {
        return this.size == ((Turtle)o).size;
    }

    public int hashCode() {
        return size/5;
    }
}
