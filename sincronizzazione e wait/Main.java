public class Main {
    public static void main(String[] args) {
        Barriera barriera = new Barriera(10); // Una singola barriera condivisa

        // Creazione e avvio dei thread
        for (int i = 0; i < 10; i++) {
            Threads thread = new Threads(barriera);
            thread.start();
        }
    }
}