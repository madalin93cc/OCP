package ocp.serialization;

import java.io.*;

/**
 * Created by Madalin.Colezea on 2/20/2017.
 */
public class BasicSerializationExample {
    public static void main(String[] args) {
        Collar collar = new Collar(3);
        Collar2 collar2 = new Collar2(4, false);
        Cat c = new Cat(5, collar, collar2);
        System.out.println(c.getCollar().getSize());
        System.out.println(c.getCollar2().getSize());
        try {
            FileOutputStream fos = new FileOutputStream("cat.ser");
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(c);
            ous.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("cat.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Cat c2 = (Cat) ois.readObject();
            System.out.println(c2.getCollar().getSize());
            System.out.println(c2.getCollar2().getSize());
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Serializable {
    int size;
//    transient Collar collar;
    Collar collar;
    transient Collar2 collar2;

    public int getSize() {
        return size;
    }

    public Collar getCollar() {
        return collar;
    }

    public Collar2 getCollar2() {
        return collar2;
    }

    public Cat(int size, Collar collar, Collar2 collar2) {
        this.size = size;
        this.collar = collar;
        this.collar2 = collar2;
    }

    private void writeObject(ObjectOutputStream os) {
        try {
            os.defaultWriteObject();
            os.writeInt(collar2.getSize());
            os.writeBoolean(collar2.isLie());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void readObject(ObjectInputStream is) {
        try{
            is.defaultReadObject();
            collar2 = new Collar2(is.readInt(), is.readBoolean());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Collar implements Serializable {
    int size;

    public Collar(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Collar2 {
    int size;
    boolean lie;

    public Collar2(int size, boolean lie) {
        this.size = size;
        this.lie = lie;
    }

    public int getSize() {
        return size;
    }

    public boolean isLie() {
        return lie;
    }
}
