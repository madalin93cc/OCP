package ocp.threads;

/**
 * Created by Madalin.Colezea on 3/6/2017.
 */
public class AccountDangerExample implements Runnable {
    private Account account = new Account();
    public static void main(String[] args) {
        AccountDangerExample ad = new AccountDangerExample();
        Thread t1 = new Thread(ad);
        Thread t2 = new Thread(ad);
        t1.setName("Lucy");
        t2.setName("Fred");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            Thread.yield(); // just for testing
            if (account.getBalance() < 10) {
                System.out.println("account is overdrawn!");
            }
        }
    }

    public synchronized void makeWithdrawal(int sum) {
        if (account.getBalance() >= sum) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withdraw(sum);
            System.out.println(Thread.currentThread().getName() + " withdrawn!");
        } else {
            System.out.println("Not enough in the account for " + Thread.currentThread().getName() + " to withdrawn: " + account.getBalance());
        }
    }

    static class Account {
        private int balance = 50;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int sum) {
            balance = balance - sum;
        }
    }
}
