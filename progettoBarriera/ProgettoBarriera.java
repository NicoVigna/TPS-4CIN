package progettoBarriera;

public class ProgettoBarriera {
    private int nThread;

    ProgettoBarriera(int nThread){
        this.nThread = nThread;
    }

    public synchronized void waitForAll() throws InterruptedException {
        nThread--;
        if (nThread > 0) {
            wait();
        } else {
            notifyAll();
        }
    }
}
//utilizzare wait() e notifyAll() per sincronizzare i thread
//serve per la mutua esclusione