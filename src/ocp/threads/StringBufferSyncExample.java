package ocp.threads;

/**
 * Created by Madalin.Colezea on 3/6/2017.
 */
public class StringBufferSyncExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("A");
        Thread t1 = new MyThread(sb);
        Thread t2 = new MyThread(sb);
        Thread t3 = new MyThread(sb);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread extends Thread {
    private StringBuffer sb;

    public MyThread(StringBuffer sb) {
        this.sb = sb;
    }

    public void run() {
        synchronized (sb) {
            for (int i = 0; i <10; i++) {
                System.out.println(getName() + " " + sb);
            }
            char c = sb.charAt(0);
            c++;
            sb.setCharAt(0, c);
        }
    }
}
