import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {

    public static void main(String[] args) {

        LinkedBlockingQueue<Double> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < 3; i++) {
            new ConsumerThread(queue).start();
        }

        for (int i = 0; i < 6; i++) {
            new ProducerThread(queue).start();
        }
    }
}
