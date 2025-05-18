public class Automobilista extends Thread {
    private Parcheggio parcheggio;

    public Automobilista(Parcheggio parcheggio, String nome) {
        super(nome);
        this.parcheggio = parcheggio;
    }

    @Override
    public void run() {
        //stampa il nome del thread e dice che è partito
        System.out.println("Automobilista: " + Thread.currentThread().getName() + " started.");

        //prova ad entrare nel Parcheggio e quando ci entra lo stampa
        parcheggio.tryEnter();
        System.out.println(getName() + " sono entrato nel parcheggio");

        //Attende due secondi
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Lascia il parcheggio
        parcheggio.release();
        System.out.println(getName() + " sono uscito dal parcheggio");
    }
}
