package ocp.concurrency.executors;

import java.util.concurrent.*;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 * 3 types:
 *  CachedThreadPool
 *  FixedThreadPool
 *  SingleThreadPool
 */
public class ExecutorServiceExamples {
    public static void main(String[] args) {
        Runnable r = new Task();
        Runnable[] runs = new Runnable[100];
        for (int i = 0; i < 100; i++) {
            runs[i] = new Task();
        }
//        Cached
//        testCached(runs);
//        Fixed
//        testFixed(runs);
//        Single
//        testSimple(runs);
//        Scheduled
        testScheduled(runs);
    }

    static void testCached(Runnable[] runs) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Runnable t: runs) {
            executorService.execute(t);
        }
        executorService.shutdown();
    }

    static void testFixed(Runnable[] runs) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (Runnable t: runs) {
            executorService.execute(t);
        }
        ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
        tpe.setCorePoolSize(8);
        tpe.setMaximumPoolSize(8);
        for (Runnable t: runs) {
            executorService.execute(t);
        }
        executorService.shutdown();
    }

    static void testSimple(Runnable[] runs) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (Runnable r: runs) {
            executorService.execute(r);
        }
        executorService.shutdown();
    }

    static void testScheduled(Runnable[] runs) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
//        executorService.schedule(runs[0], 5, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(runs[0], 2, 5, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(runs[0], 2, 5, TimeUnit.SECONDS);
    }
}

class Task implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}