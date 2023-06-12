interface outer {
    int x = 50;

    void display();

    interface inner {
        int x = 10;

        void display2();
    }
}

interface outer1 extends outer {
    int z = 80;
}

public class NestedInterface implements outer1 {
    public void display() {
        System.out.println(outer.x);
    }

    public static void main(String[] args) {
        System.out.println(z);
        NestedInterface n = new NestedInterface();
        n.display();
    }
}
