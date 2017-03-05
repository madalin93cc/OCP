package ocp.threads;

/**
 * Created by Madalin on 05/03/2017.
 * Actiunea e in metoda public void run()
 * Creare si instantiere thread:
 *  - extindere clasa java.lang.Thread - mai usoara
 *  - implementare interfata java.lang.Runnable - utilizata in practica
 */
public class BasicThreadExamples {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        t1.start();

        Runnable r = new Runnable1();
        Thread t2 = new Thread(r);
        t2.start(); // new -> runnable

        Thread t3 = new Thread(new Thread1());
        t3.start();

        Thread t4 = new Thread();
        t4.run();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Running from thread");
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Running from runnable");
    }
}
