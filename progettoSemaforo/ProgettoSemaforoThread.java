public class ProgettoSemaforoThread extends Thread {
    private Semaforo semaforo;

    public ProgettoSemaforoThread(Semaforo semaforo, String nome) {
        super(nome);
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        // Stampa il saluto e il nome del thread
        System.out.println("Saluto: " + getName());

        // Prova ad entrare nella sezione critica
        semaforo.tryEnter();
        System.out.println(getName() + " sono entrato nella zona critica");

        // Attende un tempo casuale
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Rilascia il semaforo
        semaforo.release();
        System.out.println(getName() + " sono uscito dalla zona critica");
    }
}
