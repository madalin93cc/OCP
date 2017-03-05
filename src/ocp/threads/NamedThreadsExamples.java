package ocp.threads;

/**
 * Created by Madalin on 05/03/2017.
 */
public class NamedThreadsExamples {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        NamedThread nt = new NamedThread();
        Thread t = new Thread(nt);
        t.start();
        Thread t2 = new Thread(nt, "John");
        t2.start();
        Thread t3 = new NamedThread2("Doe");
        t3.start();
        try {
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread t4 = new Thread(t3);
        t4.start();
        System.out.println(t4.getId());
    }
}

class NamedThread implements Runnable {
    public void run() {
        System.out.println("Runnable running runned from thread " + Thread.currentThread().getName());
    }
}

class NamedThread2 extends Thread {
    public NamedThread2(String string) {
        super(string);
    }

    public void run() {
        System.out.println("Runnable running runned from thread " + getName());
    }
}
