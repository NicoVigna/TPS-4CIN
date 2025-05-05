public class Threads extends java.lang.Thread {
    private Barriera barriera;

    public Threads(Barriera barriera) {
        this.barriera = barriera;
    }

    @Override
    public void run() {
        try {
            barriera.waitForAll();
            System.out.println("Thread " + Thread.currentThread().getName() + " ha superato la barriera.");
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " è stato interrotto.");
        }
    }
}