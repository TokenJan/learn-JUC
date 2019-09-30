import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWrite {

    private Lock readLock;

    private Lock writeLock;

    private int num;

    ReadWrite() {
        num = -1;
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readLock = readWriteLock.readLock();
        writeLock = readWriteLock.writeLock();
    }

    void read() throws InterruptedException {
        while (true) {
            readLock.lock();
            System.out.println(Thread.currentThread() + "准备读取数据");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + "读取的数据为" + num);
            readLock.unlock();
        }
    }

    void write() throws InterruptedException {
        while (true) {
            writeLock.lock();
            System.out.println(Thread.currentThread() + "准备写入数据");
            Thread.sleep(1000);
            num = (int)(Math.random() * 10);
            System.out.println(Thread.currentThread() + "已经写入数据" + num);
            writeLock.unlock();
            Thread.sleep(1000);
        }
    }
}
