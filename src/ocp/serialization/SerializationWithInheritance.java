package ocp.serialization;

import java.io.*;

/**
 * Created by Madalin on 20/02/2017.
 */
public class SerializationWithInheritance {
    public static void main(String[] args) {
        Dog d = new Dog("Dog", 30);
        System.out.println(d.name + " " +d.height);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("dog.ser"));
            os.writeObject(d);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("dog.ser"));
            Dog d2 = (Dog) os.readObject();
            os.close();
            System.out.println(d2.name + " " + d2.height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Animal {
    int height = 42;
}

class Dog extends Animal implements Serializable {
    String name;

    public Dog(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
