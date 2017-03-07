package ocp.concurrency.executors;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 */
public class CallableExamples {
    public static void main(String[] args) {
        Callable<Integer> c = new MyCollable();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> future = executorService.submit(c);
        try {
            Integer rez = future.get();
            System.out.println("Run: " + rez);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Failed");
        }
        executorService.shutdown();

        Runnable r = new MyRunnable();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        Future future1 = executorService1.submit(r);
        try {
            if (future1.get() == null) {
                System.out.println("Done");
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Failed");
        }

        executorService1.shutdown();
        try {
            boolean b = executorService1.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executorService1.isTerminated()) {
                List<Runnable> unfinished = executorService1.shutdownNow();
                System.out.println(unfinished);
            }
        }

    }
}

class MyCollable implements Callable<Integer> {
    @Override
    public Integer call() {
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 1; i <= count; i++) {
            System.out.println("Running... " + i);
        }
        return count;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        int count = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i =0; i <= 10000; i++) {
            System.out.println("Running... " + i);
        }
    }
}
