package ocp.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Madalin.Colezea on 2/28/2017.
 */
public class PriorityQueueExamples {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        IntRev intRev = new IntRev();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(10, intRev);

        int[] ints = {1,5,3,7,6,9,8};

        for (int x: ints) {
            pq1.offer(x);
            pq2.offer(x);
        }

        for (int x: ints) {
            System.out.print(pq1.poll() + " ");
        }
        System.out.println("\n" + pq1);

        System.out.println(pq2.size());
        System.out.println(pq2.peek());
        System.out.println(pq2.size());
        System.out.println(pq2.poll());
        System.out.println(pq2.size());

        for (int x: ints) {
            System.out.print(pq2.poll() + " ");
        }
    }
}

class IntRev implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i2-i1;
    }
}
