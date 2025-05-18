public class Main {
    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio(3);
        Automobilista automobilista[] = new Automobilista[Runtime.getRuntime().availableProcessors()];

        for(int i = 0; i< automobilista.length; i++){
            automobilista[i] = new Automobilista(parcheggio, "Automobilista - "+ (i+1));
            automobilista[i].start();
        }

        for (Automobilista a : automobilista) {
           try {
            a.join();
           } catch (Exception e) {
            // TODO: handle exception
           }
        }
        System.out.println("tutti i Thread hanno terminato");
    }
}