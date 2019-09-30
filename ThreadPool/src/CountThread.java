class CountThread extends Thread {

    private int count;

    CountThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + count);
    }
}