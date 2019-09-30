import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        // Single Thread Executor 单个线程后台
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        executeCount(singleThreadExecutor);
        System.out.println("=======================This is Single Thread Executor=======================");

        // Fixed Thread Pool 固定大小线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        executeCount(newFixedThreadPool);
        System.out.println("=======================This is Fixed Thread Pool=======================");

        // Cached Thread Pool 无界线程池，可以进行自动线程回收
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        executeCount(cachedThreadPool);
        System.out.println("=======================This is Cached Thread Pool=======================");

        // Scheduled Thread Pool 延迟连接池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        executeCount(scheduledThreadPool);
        System.out.println("=======================This is Scheduled Thread Pool=======================");
    }

    private static void executeCount(ExecutorService executorService) {
        for (int i = 0; i < 100; i++) {
            executorService.execute(new CountThread(i));
        }
        executorService.shutdown();
    }

    private static void executeCount(ScheduledExecutorService scheduledExecutorService) {
        scheduledExecutorService.scheduleAtFixedRate(new CountThread(1), 0, 1000, TimeUnit.MILLISECONDS);
    }

}


