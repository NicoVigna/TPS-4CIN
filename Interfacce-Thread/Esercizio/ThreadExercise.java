/* (3+2a)*(5b-7)+(8-3c) questa è l'operazione che devo fare */
public class ThreadExercise {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = 4;

        Thread1 t1 = new Thread1(a);
        Thread2 t2 = new Thread2(b);
        Thread3 t3 = new Thread3(c);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = t1.getResult() * t2.getResult() + t3.getResult();
        System.out.println(result);
    }
}

class Thread1 extends Thread {
    private int a;
    private int result;

    public Thread1(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        result = 3 + 2 * a;
    }

    public int getResult() {
        return result;
    }
}

class Thread2 extends Thread {
    private int b;
    private int result;

    public Thread2(int b) {
        this.b = b;
    }

    @Override
    public void run() {
        result = 5 * b - 7;
    }

    public int getResult() {
        return result;
    }
}

class Thread3 extends Thread {
    private int c;
    private int result;

    public Thread3(int c) {
        this.c = c;
    }

    @Override
    public void run() {
        result = 8 - 3 * c;
    }

    public int getResult() {
        return result;
    }
}