import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    private final int[] accounts;

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    Bank(int size) {
        accounts = new int[size];
        for (int i = 0; i < size; i++) {
            accounts[i] = 1000;
        }
    }

    void transfer(int from, int to, int amount) throws InterruptedException {
        lock.lock();
        while (accounts[from] < amount) {
            condition.await();
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%d from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance:%d\n", sum());
        condition.signalAll();
        lock.unlock();
    }

    private int sum() {
        int sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
    }

    int getAccountSize() {
        return accounts.length;
    }
}