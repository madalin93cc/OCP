package ocp.threads;

/**
 * Created by Madalin on 05/03/2017.
 */
public class JoinExamples {
    public static void main(String[] args) {
        Thread t = new ThreadToJoin();
        t.start();
        try {
            t.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class ThreadToJoin extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
