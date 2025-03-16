public class ThreadExercise {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        int x = 3 - 2;
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int y = t1.getY();
        int z = x + y;

        System.out.println("Il risultato è: " + z);
    }
}


class MyThread extends Thread {
    int y = 0;

    @Override
    public void run() {
        y = 5 + 4;
    }

    public int getY() {
        return y;
    }
}
