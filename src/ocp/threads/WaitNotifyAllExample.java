package ocp.threads;

/**
 * Created by Madalin.Colezea on 3/6/2017.
 */
public class WaitNotifyAllExample {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        new Reader(c).start();
        new Reader(c).start();
        new Reader(c).start();
        c.start();
    }
}

class Calculator extends Thread {
    int total;
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total = total + i;
            }
            notifyAll();
        }
    }
}

class Reader extends Thread {
    Calculator c;

    public Reader(Calculator c) {
        this.c = c;
    }

    public void run() {
        synchronized (c) {
            try {
                System.out.println(getName() + " waiting");
                c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " " + c.total);
        }
    }
}