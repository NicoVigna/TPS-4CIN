public class Semaforo {
    private int maxPermessi;
    private int permessiDisponibili;

    public Semaforo(int numThreadPermessi) {
        this.maxPermessi = numThreadPermessi;
        this.permessiDisponibili = numThreadPermessi;
    }

    public synchronized void tryEnter() {
        while (permessiDisponibili == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        permessiDisponibili--;
    }

    public synchronized void release() {
        permessiDisponibili++;
        notify();
    }
}