public class ClassLockThread extends Thread {
    private Trans trans;

    ClassLockThread(Trans trans) {
        this.trans = trans;
    }

    public void run() {
        while (true)
        {
            trans.printStaticNum();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
