package ocp.concurrency.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class BasicCustomExecutorExample {
    public static void main(String[] args) {
        Executor e1 = new ExecutorCurrentThread();
        Executor e2 = new ExecutorNewThread();

        e1.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " current");
            }
        });

        e2.execute(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " new");
            }
        });
    }
}

class ExecutorCurrentThread implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}

class ExecutorNewThread implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
