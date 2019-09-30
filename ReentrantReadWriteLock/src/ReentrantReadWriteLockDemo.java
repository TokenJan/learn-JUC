public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        final ReadWrite readWrite = new ReadWrite();

        for(int i = 0; i < 3; i++) new Thread(() -> {
            try {
                readWrite.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                readWrite.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
