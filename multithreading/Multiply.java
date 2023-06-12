class Operate {
    public synchronized void printMul(double d) {
        for (int i = 1; i < 11; i++) {
            System.out.println(d * i);
        }
    }
}

public class Multiply implements Runnable {
    Operate op = new Operate();
    private double d;

    Multiply(Operate op, double d) {
        this.d = d;
        this.op = op;
    }

    public void run() {
        // synchronized (op) {
        op.printMul(d);
        // }

    }

    public static void main(String[] args) {
        Operate op = new Operate();
        Thread t1 = new Thread(new Multiply(op, 7));
        Thread t2 = new Thread(new Multiply(op, 4));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
