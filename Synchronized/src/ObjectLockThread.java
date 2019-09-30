public class ObjectLockThread extends Thread {
    private Trans trans;

    ObjectLockThread(Trans trans) {
        this.trans = trans;
    }

    public void run() {
        while (true)
        {
            trans.printNum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
