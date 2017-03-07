package ocp.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class ConditionExample {
    public static void main(String[] args) {
        Thread t1 = new ConditionThread();
        Thread t2 = new ConditionThread();
        t1.setName("th1");
        t2.setName("th2");
        t1.start();
        t2.start();
    }
}

class ConditionThread extends Thread {
    static ReentrantLock lock;
    static Condition condition1;
    static {
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
    }

    public void run() {
        lock.lock();
        if (getName().equals("th1")) {
            try {
                System.out.println(getName() + " ready to wait");
                condition1.await();
                System.out.println(getName() + " exit from await" + " " + lock.isHeldByCurrentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        } else {
            try {
                condition1.signalAll();
            } finally {
                lock.unlock();
            }

            System.out.println(getName() + " signals");
        }
    }
}
