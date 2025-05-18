public class Semaforo {
    private int permessiDisponibili;

    public Semaforo(int numThreadPermessi) {
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