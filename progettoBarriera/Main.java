package progettoBarriera;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int numeroCore = Runtime.getRuntime().availableProcessors(); // Ottieni il numero di core disponibili
        ProgettoBarriera barriera = new ProgettoBarriera(numeroCore); // Una singola barriera condivisa
        ArrayList<Thread> threadList = new ArrayList<>(); // Lista per tenere traccia dei thread

        // Creazione e avvio dei thread
        for (int i = 0; i < numeroCore; i++) {
            ProgettoBarrieraThread thread = new ProgettoBarrieraThread(barriera);
            thread.setName("faraButt " + (i + 1)); // Imposta il nome del thread
            threadList.add(thread); // Aggiungi il thread alla lista
            thread.start(); // Avvia il thread
        }

        // Attendi che tutti i thread terminino
        for (Thread thread : threadList) {
            try {
                thread.join(); // Aspetta che ogni thread termini
            } catch (InterruptedException e) {
                System.out.println("Il thread principale è stato interrotto.");
            }
        }

        // Messaggi finali
        System.out.println("Tutti i thread hanno superato la barriera.");
        System.out.println("Il thread principale ha terminato.");
    }
}