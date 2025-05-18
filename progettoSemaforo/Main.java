public class Main {
    public static void main(String[] args) {
        ProgettoSemaforoThread[] threads = new ProgettoSemaforoThread[10];
        Semaforo semaforo = new Semaforo(3); // 3 thread possono entrare nella zona critica

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ProgettoSemaforoThread(semaforo, "Thread-" + i);
            threads[i].start();
        }

        // Attendi che tutti i thread terminino
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tutti i thread hanno terminato.");
    }
}
