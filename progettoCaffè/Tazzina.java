public class Tazzina {
    int numTazzine = 3;

    public Tazzina() {

    }

    public synchronized void tryEnter() {
        while (numTazzine == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        numTazzine--;

    }

    public synchronized void release() {
        numTazzine++;
        notify();
    }
}