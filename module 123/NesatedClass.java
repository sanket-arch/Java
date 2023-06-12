class OuterClass {
    void display() {
        System.out.println("i am outer class");
    }

    class InnerClass {
        final int X=10;
        public void display1() {
            System.out.println("i am inner class");
            display();
        }
    }
}

public class NesatedClass {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass inc = oc.new InnerClass();
        inc.display1();
    }
}
