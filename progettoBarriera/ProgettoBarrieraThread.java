package progettoBarriera;

import java.util.Random;

public class ProgettoBarrieraThread extends java.lang.Thread {
    private ProgettoBarriera barriera;

    public ProgettoBarrieraThread(ProgettoBarriera barriera) {
        this.barriera = barriera;
    }

    @Override
    public void run() {
        Random random = new Random();
        int stuckTime = 10000 + random.nextInt(20000); // Genera un tempo casuale tra 1000 e 5000 ms
        try {
            Thread.sleep(stuckTime); // Simula il tempo di attesa del thread
            System.out.println("Thread " + Thread.currentThread().getName() + " è in attesa alla barriera.");
            barriera.waitForAll();
            System.out.println("Thread " + Thread.currentThread().getName() + " ha superato la barriera.");
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " è stato interrotto.");
        }
    }
}