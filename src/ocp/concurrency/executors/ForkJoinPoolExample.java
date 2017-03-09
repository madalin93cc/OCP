package ocp.concurrency.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Madalin.Colezea on 3/8/2017.
 * ForkJoinTask -> compute()
 *                 fork()
 *                 join()
 *         - subclasses:
 *                 -> RecursiveTask
 *                 -> RecursiveAction
 */
public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int [] data = new int[10_000_000];
        ForkJoinPool pool = new ForkJoinPool();
        RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
        long l1 = System.currentTimeMillis();
        pool.invoke(action);
        RandomFindMaxTask task = new RandomFindMaxTask(data, 0, data.length);
        Integer rez = pool.invoke(task);
        System.out.println("Max pos: " + rez + " value: " + data[rez]);
        System.out.println(System.currentTimeMillis() - l1);
    }
}

class RandomInitRecursiveAction extends RecursiveAction {
    private int [] data;
    private int start;
    private int end;

    public RandomInitRecursiveAction(int [] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public void compute() {
        if (end - start <= 10000) {
            for (int i = start; i < end; i++) {
                data[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            int middle = ((end - start) / 2) + start;
            RandomInitRecursiveAction a1 = new RandomInitRecursiveAction(data, start, middle);
            RandomInitRecursiveAction a2 = new RandomInitRecursiveAction(data, middle, end);
//            a1.fork();
//            a2.compute();
//            a1.join();
//            sau
            invokeAll(a2, a1);
        }
    }
}

class RandomFindMaxTask extends RecursiveTask<Integer> {
    int [] data;
    int start;
    int end;

    public RandomFindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer compute() {
        if (end - start <= 10000) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                if (data[i] > data[maxPos]) {
                    maxPos = i;
                }
            }
            return maxPos;
        } else {
            int middle = ((end - start) / 2) + start;
            RandomFindMaxTask a1 = new RandomFindMaxTask(data, start, middle);
            RandomFindMaxTask a2 = new RandomFindMaxTask(data, middle, end);
            a1.fork();
            Integer right = a2.compute();
            Integer left = a1.join();
            if (data[left] > data[right]) {
                return left;
            } else if (data[right] > data[left]) {
                return right;
            } else {
                return left < right? left: right;
            }
        }
    }
}
