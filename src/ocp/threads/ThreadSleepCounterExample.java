package ocp.threads;

/**
 * Created by Madalin on 05/03/2017.
 */
public class ThreadSleepCounterExample {
    public static void main(String[] args) {
        ThreadCounter tc = new ThreadCounter();
        Thread t = new Thread(tc);
        t.start();
    }
}

class ThreadCounter implements Runnable {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
