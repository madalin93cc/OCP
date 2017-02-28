package ocp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class ListIteratorExamples {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("a"));
        dogs.add(new Dog("b"));
        dogs.add(new Dog("c"));

        testGenericIterator(dogs);
        testIterator(dogs);

        Object[] objects = dogs.toArray();
        for (Object obj: objects) {
            System.out.println(((Dog) obj).getName());
        }

        System.out.println(dogs.size());
        System.out.println(dogs.indexOf(new Dog("a")));
        System.out.println(dogs.contains(new Dog("b")));
    }

    private static void testGenericIterator(List<Dog> dogs) {
        Iterator<Dog> it = dogs.iterator();

        while (it.hasNext()) {
            Dog dog = it.next();
            System.out.println(dog.getName());
//            it.remove();
        }
    }

    private static void testIterator(List<Dog> dogs) {
        Iterator it = dogs.iterator();

        while (it.hasNext()) {
            Object obj = it.next();
            if (obj instanceof Dog) {
                Dog dog = (Dog) obj;
                System.out.println(dog.getName());
            }
        }
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            return dog.getName().equals(name);
        }
        return false;
    }
}
