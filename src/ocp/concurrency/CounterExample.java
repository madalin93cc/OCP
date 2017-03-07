package ocp.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class CounterExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterIncr c1 = new CounterIncr(counter);
        CounterIncr c2 = new CounterIncr(counter);
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter.getCount().get());
    }
}

class Counter {
//    private int count; // wrong result
    private AtomicInteger count = new AtomicInteger();

    public void increment() {
//        count++;
        count.getAndIncrement();
    }

//    public int getCount() {
//        return count;
//    }

    public AtomicInteger getCount() {
        return count;
    }
}

class CounterIncr extends Thread {
    private Counter counter;

    public CounterIncr(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
