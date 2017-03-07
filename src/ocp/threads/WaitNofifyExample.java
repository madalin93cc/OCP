package ocp.threads;

/**
 * Created by Madalin.Colezea on 3/6/2017.
 */
public class WaitNofifyExample {
    public static void main(String[] args) {
        NotifyThread nt = new NotifyThread();
        nt.start();
        synchronized (nt) {
            try {
                System.out.println("Waiting");
                nt.wait();
                System.out.println("Waited");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class NotifyThread extends Thread {
    public void run() {
        synchronized (this) {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            System.out.println("Sum: " + sum);
            notify();
        }
    }
}
