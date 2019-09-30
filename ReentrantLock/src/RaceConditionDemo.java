import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionDemo {

    static int counter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==========================This is Non-atomic increase and decrease==========================");
        CountThread increaseThread = new CountThread(1);
        CountThread decreaseThread = new CountThread(2);
        increaseThread.start();
        decreaseThread.start();

        increaseThread.join();
        decreaseThread.join();

        System.out.println("==========================This is Atomic increase and decrease==========================");
        AtomicIncreaseThread atomicIncreaseThread = new AtomicIncreaseThread();
        AtomicDecreaseThread atomicDecreaseThread = new AtomicDecreaseThread();
        atomicIncreaseThread.start();
        atomicDecreaseThread.start();
    }
}
