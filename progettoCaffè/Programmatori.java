public class Programmatori extends Thread {
    Tazzina tazzina = new Tazzina();
    Macchinetta macchinetta = new Macchinetta();

    public Programmatori(String nome, Macchinetta macchinetta, Tazzina tazzina) {
        super(nome);
        this.tazzina = tazzina;
        this.macchinetta = macchinetta;
    }

    @Override
    public void run() {
        // scrive di essere partito
        System.out.println(getName() + " - sono partito");

        // prova a prendere una tazzina
        tazzina.tryEnter();
        System.out.println(getName() + " - ho preso la tazzina");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // prova a fare il caffè e poi lascia la macchinetta
        macchinetta.tryEnter();
        System.out.println(getName() + " - sto facendo il caffè");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // rilascia la tazzina e la macchinetta
        macchinetta.release();
        System.out.println(getName() + " - ho lasciato la macchinetta");
        tazzina.release();
        System.out.println(getName() + " - ho sciacquato la tazzina");
    }
}
