import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerThread extends Thread {

    private LinkedBlockingQueue<Double> queue;

    ConsumerThread(LinkedBlockingQueue<Double> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ": consume product" + queue.take() + " left products: " + queue.size());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
