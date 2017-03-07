package ocp.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class ReentrantLockExamples {
    public static void main(String[] args) {
        Thread t1 = new LockThread();
        Thread t2 = new LockThread();

        t1.start();
        t2.start();
    }
}

class LockThread extends Thread {
    public void run() {
        simpleLocking();
        tryLockNoLoops();
        tryLockLoop();
    }

    void simpleLocking() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            // do work
        } finally {
            lock.unlock();
        }
    }

    void tryLockNoLoops() {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        boolean q1 = l1.tryLock();
        boolean q2 = l2.tryLock();

        try {
            if (q1 && q2) {
                // do work
            }
        } finally {
            if (q1) l1.unlock();
            if (q2) l2.unlock();
        }
    }

    void tryLockLoop() {
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();

        loop:
            while (true) {
                boolean q1 = l1.tryLock();
                boolean q2 = l2.tryLock();

                try {
                    if (q1 && q2) {
                        // do work
                        break loop;
                    }
                } finally {
                    if (q1) l1.unlock();
                    if (q2) l2.unlock();
                }
            }
    }
}
