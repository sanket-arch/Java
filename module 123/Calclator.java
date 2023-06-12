import packages.Mul;

public class Calclator {
    public  void display(){
        System.out.println("i am from interface");
    }
    public static void main(String[] args) {
        Mul m=new Mul();
        System.out.println( m.mul(10, 20));
    }
}
