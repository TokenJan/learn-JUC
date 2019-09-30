import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Counter counter = new Counter();
            for (int i = 0; i < 10; i++)
                executorService.execute(() -> {
                    for (int j = 0; j < 1000; j++)
                        counter.increase();
                });

            Thread.sleep(1000);
            System.out.println(counter.getNum());
        }
    }
}
