package ocp.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class BoundedQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(4);
//        BlockingQueue<Integer> bq = new SynchronousQueue<>();
        new Consumer(bq).start();
        new Producer(bq).start();
    }
}

class Consumer extends Thread {
    private BlockingQueue q;

    public Consumer(BlockingQueue q) {
        this.q = q;
    }

    public void run() {
//        System.out.println(q.element());
        try {
            while (true) {
                System.out.println(q.take());
//                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer extends Thread {
    private BlockingQueue q;

    public Producer(BlockingQueue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                q.offer(i);
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
