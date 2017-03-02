package ocp.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madalin on 02/03/2017.
 */
public class GenericsAndInheritanceExamples {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
//        List<Dog> animals = new ArrayList<>();
//        animals.add(new Cat());
//        animals.add(new Dog());
        addAnimal(animals);
        addAll2(animals);

        List<?> ani = new ArrayList<Animal>();
        List<? extends Animal> ani2 = new ArrayList<Dog>();
    }

    static void addAnimal(List<? super Animal> animals) {
//        animals.add(new Dog());
        animals.add(new Cat());
    }

    static void addAll2(List<?> animals) {
//        animals.add(new Dog());
    }
}

class Animal {

}

class Dog extends Animal {

}

class Cat extends Animal {

}
