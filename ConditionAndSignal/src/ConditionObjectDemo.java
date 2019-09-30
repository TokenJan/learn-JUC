public class ConditionObjectDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadSize = 1000;
        int bankSize = 5;
        Bank bank = new Bank(bankSize);
        Thread[] threads = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threads[i] = new TransferThread(bank);
        }

        for (int i = 0; i < threadSize; i++) {
            threads[i].start();
        }
    }
}