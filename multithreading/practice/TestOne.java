//thread for a
class PrintA extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("a");
        }
    }
}

// thread for b
class PrintB extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("b");
        }
    }
}

// thread for int
class Printint extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class TestOne {
    public static void main(String[] args) {
        PrintA a = new PrintA();
        PrintB b = new PrintB();
        Printint i = new Printint();

        a.start();
        b.start();
        i.start();
    }
}
