public class TransferThread extends Thread {

    private Bank bank;

    TransferThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            int amount = (int) (1000 * Math.random());
            int from = (int) (bank.getAccountSize() * Math.random());
            int to = (int) (bank.getAccountSize() * Math.random());
            try {
                bank.transfer(from, to, amount);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
