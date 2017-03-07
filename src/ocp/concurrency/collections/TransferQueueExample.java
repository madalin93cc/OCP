package ocp.concurrency.collections;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class TransferQueueExample {
    public static void main(String[] args) {
        TransferQueue<Integer> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add(1));
        System.out.println(tq.offer(2));
        try {
            System.out.println(tq.offer(3, 100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            tq.put(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(tq.element());
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        try {
            System.out.println(tq.poll(100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(tq.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tq.clear();
        new A(tq).start();
        new B(tq).start();
    }
}

class A extends Thread {
    TransferQueue q;

    public A(TransferQueue q) {
        this.q = q;
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                q.transfer(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class B extends Thread {
    TransferQueue q;

    public B(TransferQueue q) {
        this.q = q;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                System.out.println(q.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
