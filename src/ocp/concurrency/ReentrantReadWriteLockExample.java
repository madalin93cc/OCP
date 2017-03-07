package ocp.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 * - 2 different threads can not hold the read lock and the write lock respectively
 * - multiple threads can hold the read lock
 * - un singur thread poate avea lock-ul de scriere la un moment dat
 */
public class ReentrantReadWriteLockExample {
    public static void main(String[] args) {
        MaxValueCollection maxValueCollection = new MaxValueCollection();
        ReadWriteThread1 t1 = new ReadWriteThread1(maxValueCollection);
        ReadWriteThread2 t2 = new ReadWriteThread2(maxValueCollection);
        t1.start();
        t2.start();
    }
}

class ReadWriteThread1 extends Thread {
    private MaxValueCollection maxValueCollection;

    public ReadWriteThread1(MaxValueCollection c) {
        this.maxValueCollection = c;
    }

    public void run() {
        maxValueCollection.add(2);
        maxValueCollection.max();
        maxValueCollection.add(5);
    }
}

class ReadWriteThread2 extends Thread {
    private MaxValueCollection maxValueCollection;

    public ReadWriteThread2(MaxValueCollection c) {
        this.maxValueCollection = c;
    }

    public void run() {
        maxValueCollection.max();
        maxValueCollection.max();
        maxValueCollection.max();
    }
}

class MaxValueCollection {
    private List<Integer> integers = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void add(Integer i) {
        lock.writeLock().lock();
        try {
            integers.add(i);
            System.out.println(Thread.currentThread().getName() + " added " + i);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int max() {
        lock.readLock().lock();
        try {
            int max = Collections.max(integers);
            System.out.println(Thread.currentThread().getName() + " got max " + max);
            return max;
        } finally {
            lock.readLock().unlock();
        }
    }
}
