class Bank {
    private int balance = 0;

    public synchronized void withdraw(int amount) {
        System.out.println("going to withraw");
        if (balance < amount) {
            System.out.println("less balance waiting for deposit");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        balance -= amount;
        System.out.println("withdrawn");
    }

    public synchronized void deposit(int amount) {
        System.out.println("going to deposit");
        balance += amount;
        System.out.println("deposited");
        notify();
    }
}

class Withdraw extends Thread {
    Bank b;

    Withdraw(Bank b) {
        this.b = b;
    }

    public void run() {
        b.withdraw(1000);
    }
}

class Deposit extends Thread {
    Bank b;

    Deposit(Bank b) {
        this.b = b;
    }

    public void run() {
        b.deposit(2000);
    }
}

public class Customer {

    public static void main(String[] args) {
        Bank b = new Bank();
        Withdraw t1 = new Withdraw(b);
        Deposit t2 = new Deposit(b);
        t1.start();
        t2.start();
    }
}
