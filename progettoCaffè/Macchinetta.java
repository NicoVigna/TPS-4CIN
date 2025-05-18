public class Macchinetta {
    int utilizzatori = 2;

    public synchronized void tryEnter() {
        while (utilizzatori == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        utilizzatori--;
    }

    public synchronized void release() {
        utilizzatori++;
        notify();
    }
}
