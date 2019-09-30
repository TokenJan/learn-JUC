import java.util.concurrent.LinkedBlockingQueue;

public class ProducerThread extends Thread {

    private LinkedBlockingQueue<Double> queue;

    ProducerThread(LinkedBlockingQueue<Double> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                double product = Math.random();
                System.out.println(Thread.currentThread().getName() + ": produce products " + product + " left products: " + queue.size());
                queue.put(product);
                Thread.sleep(1900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
