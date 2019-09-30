import java.util.concurrent.locks.ReentrantLock;

class CountThread extends Thread {

    private int type;
    private static ReentrantLock lock = new ReentrantLock(true);

    CountThread(int type) {
        this.type = type;
    }

    @Override
    public void run() {
        if (type == 1) {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ": " + ++RaceConditionDemo.counter);
                lock.unlock();
            }
        }

        else {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ": " + --RaceConditionDemo.counter);
                lock.unlock();
            }
        }

    }
}