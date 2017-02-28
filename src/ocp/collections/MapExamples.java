package ocp.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class MapExamples {
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("2", "2 val");
        Cat c = new Cat("cat");
        map.put(c, "cat");
//        System.out.println(map.get(c));
        System.out.println(map.get(new Cat("cat"))); // not working until equals and hashcode is overriden
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            return ((Cat) o).getName().equals(name);
        }
        return false;
    }
}
