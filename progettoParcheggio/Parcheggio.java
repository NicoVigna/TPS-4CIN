public class Parcheggio {
    int postiDisponibili;
    public Parcheggio(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public synchronized void tryEnter(){
        while (postiDisponibili == 0){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        postiDisponibili--;
    }

    public synchronized void release(){
        postiDisponibili++;
        notify();
    }
}
