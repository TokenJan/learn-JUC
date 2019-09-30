public class SynchronizedMethodDemo {

    public static void main(String[] args) {
        Trans trans = new Trans();
        Thread thread1 = new ObjectLockThread(trans);
        Thread thread2 = new ClassLockThread(trans);
        thread1.start();
        thread2.start();
    }
}
