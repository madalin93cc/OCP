package ocp.concurrency.collections;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Madalin.Colezea on 3/7/2017.
 * CopyOnWriteArrayList
 * CopyOnWriteArraySet
 */
public class CopyOnWriteExamples {
    public static void main(String[] args) throws InterruptedException{
        List<Integer> list = new CopyOnWriteArrayList<>();
        Thread c1 = new Thread(new COWThread(list));
        Thread c2 = new Thread(new COWThread(list));
        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println(list);
        System.out.println(list.size());

        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
//            listIterator.remove(); // UnsupportedOperationException
        }
    }
}

class COWThread implements Runnable {
    private List elements;

    public COWThread(List elements) {
        this.elements = elements;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            elements.add(i);
        }
    }
}
