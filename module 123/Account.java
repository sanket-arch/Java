import java.util.*;

public class Account {
    private String acc_number, name;
    private double acc_balance;

    public Account(double acc_balance, String name, String acc_number) {
        this.acc_balance = acc_balance;
        this.name = name;
        this.acc_number = acc_number;
    }

    void setAccNumber(String acc_number) {
        this.acc_number = acc_number;
    }

    void setAccBalance(double acc_balance) {
        this.acc_balance = acc_balance;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    String getAccountNumber() {
        return this.acc_number;
    }

    double getBalance() {
        return this.acc_balance;
    }

    void deposit(double Dmoney) {
        this.acc_balance += Dmoney;
    }

    void withdraw(double Wmoney) {
        if (Wmoney > acc_balance) {
            System.out.println("Not enough Balance");
            return;
        }
        this.acc_balance -= Wmoney;
    }

    double calculateInterest(double time) {
        double intrest = (acc_balance * time * 6) / 100;
        return intrest;
    }

    public static void main(String[] args) {
        Scanner getData = new Scanner(System.in);
        Account cus1 = new Account(1235.00, "Sanket", "123456789");

        System.out.println("enter amount you want to withdraw");
        double wAmount = getData.nextDouble();
        String Name = cus1.getName();
        System.out.println(Name);
        System.out.println(cus1.getBalance());
        cus1.deposit(1000);
        System.out.println(cus1.getBalance());
        cus1.withdraw(wAmount);
        System.out.println(cus1.getBalance());

        getData.close();
    }
}
