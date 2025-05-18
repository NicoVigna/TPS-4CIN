public class Main {
    public static void main(String[] args) {
        Macchinetta macchinetta = new Macchinetta();
        Tazzina tazzina = new Tazzina();
        Programmatori programmatori[] = new Programmatori[Runtime.getRuntime().availableProcessors()];

        for (int i = 0; i < programmatori.length; i++) {
            programmatori[i] = new Programmatori("Programmatore - " + (i + 1), macchinetta, tazzina);
            programmatori[i].start();
        }

        for (Programmatori a : programmatori) {
            try {
                a.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("tutti hanno fatto il caffè");
    }
}