class BankAccount {
      private double balance;

      public BankAccount(double d) {
            balance = d;
      }

      public synchronized void setBalance(double d) {
            balance = balance + d;
      }

      public synchronized double getBalance() {
            return balance;
      }

}

public class Teller implements Runnable {
      private BankAccount ba;
      private double d;

      public Teller(BankAccount ba, double d) {
            this.ba = ba;
            this.d = d;
      }

      public void run() {
            ba.setBalance(d);
      }

      public static void main(String[] args) {
            BankAccount ba = new BankAccount(1000);
            Thread t1 = new Thread(new Teller(ba, 2000));
            Thread t2 = new Thread(new Teller(ba, 3000));
            t1.start();
            t2.start();
            BankAccount ba2 = new BankAccount(2000);
            Thread t3 = new Thread(new Teller(ba2, 3000));
            Thread t4 = new Thread(new Teller(ba2, 4000));
            // ba2.setBalance(-2000);
            t3.start();
            t4.start();
            try {
                  t1.join();
                  t2.join();
                  t3.join();
                  t4.join();
            } catch (InterruptedException e) {
            }
            System.out.println(ba.getBalance());
            System.out.println(ba2.getBalance());// o/p should be 6000
      }// main
}// Teller
