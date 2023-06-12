class myException extends Exception {
    public myException(String s) {
        super(s);
    }
}

public class ExceptionP {
    public static void calc(int x) throws myException {
        int a = 10;
        if (x == 0) {
            throw new myException("can't divide by zero");
        } else {
            System.out.println(a / x);
        }
    }

    public static void main(String[] args) {
        // int a=10,b=0;
        // try{
        // int c=a/b;
        // System.out.println(c);
        // }
        // catch(ArithmeticException e)
        // {
        // System.err.println(e);
        // }
        // finally{
        // System.out.println("hello from finally block");
        // }
        // System.out.println("i am outside");

        try {
            calc(0);
        } catch (myException e) {
            e.printStackTrace();
        }

    }
}
